package com.loserico.mybatisplus.poem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.loserico.mybatisplus.poem.entity.Poem;
import com.loserico.mybatisplus.poem.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/poem")
public class PoemController {

    @Autowired
    private PoemService poemService;

    // 分页查询古诗词
    @GetMapping("/list")
    public Page<Poem> list(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int size) {
        return poemService.page(new Page<>(page, size));
    }

    // 插入新的古诗词
    @PostMapping("/add")
    public boolean add(@RequestBody Poem poem) {
        return poemService.save(poem);
    }

    @GetMapping("/byDynasty")
    public List<Poem> byDynasty(@RequestParam String dynasty) {
        return poemService.selectByDynasty(dynasty);
    }

    // 根据作者查询古诗词
    @GetMapping("/byAuthor")
    public List<Poem> byAuthor(@RequestParam String author) {
        LambdaQueryWrapper<Poem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Poem::getAuthor, author);
        return poemService.list(queryWrapper);
    }

    // 逻辑删除古诗词
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return poemService.removeById(id);
    }

    // 更新古诗词
    @PutMapping("/update")
    public boolean update(@RequestBody Poem poem) {
        return poemService.updateById(poem);
    }

    @GetMapping("/byCondition")
    public List<Poem> byCondition(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) String dynasty) {
        return poemService.selectByCondition(title, author, dynasty);
    }

    @GetMapping("/byComplexCondition")
    public List<Poem> byComplexCondition(@RequestParam(required = false) String title,
                                         @RequestParam(required = false) String author) {
        return poemService.selectByComplexCondition(title, author);
    }

    @GetMapping("/byWhereCondition")
    public List<Poem> byWhereCondition(@RequestParam(required = false) String title,
                                       @RequestParam(required = false) String author,
                                       @RequestParam(required = false) String dynasty) {
        return poemService.selectByWhereCondition(title, author, dynasty);
    }

    @GetMapping("/byIds")
    public List<Poem> byIds(@RequestParam List<Long> ids) {
        return poemService.selectByIds(ids);
    }

    @GetMapping("/byTrimCondition")
    public List<Poem> byTrimCondition(@RequestParam(required = false) String title,
                                      @RequestParam(required = false) String author) {
        return poemService.selectByTrimCondition(title, author);
    }
}