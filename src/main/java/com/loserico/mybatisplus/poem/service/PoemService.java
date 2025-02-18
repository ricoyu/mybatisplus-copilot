package com.loserico.mybatisplus.poem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.loserico.mybatisplus.poem.entity.Poem;
import com.loserico.mybatisplus.poem.mapper.PoemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemService extends ServiceImpl<PoemMapper, Poem> {

	public List<Poem> selectByDynasty(String dynasty) {
		return baseMapper.selectByDynasty(dynasty);
	}
	public List<Poem> selectByCondition(String title, String author, String dynasty) {
		return baseMapper.selectByCondition(title, author, dynasty);
	}

	public List<Poem> selectByComplexCondition(String title, String author) {
		return baseMapper.selectByComplexCondition(title, author);
	}

	public List<Poem> selectByWhereCondition(String title, String author, String dynasty) {
		return baseMapper.selectByWhereCondition(title, author, dynasty);
	}

	public boolean updatePoem(Poem poem) {
		return baseMapper.updatePoem(poem) > 0;
	}

	public List<Poem> selectByIds(List<Long> ids) {
		return baseMapper.selectByIds(ids);
	}

	public List<Poem> selectByTrimCondition(String title, String author) {
		return baseMapper.selectByTrimCondition(title, author);
	}
}