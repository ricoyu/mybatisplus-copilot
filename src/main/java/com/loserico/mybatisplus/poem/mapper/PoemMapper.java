package com.loserico.mybatisplus.poem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loserico.mybatisplus.poem.entity.Poem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface PoemMapper extends BaseMapper<Poem> {

	// 查询某个朝代的古诗词
	@Select("SELECT * FROM poem WHERE dynasty = #{dynasty} AND is_deleted = 0")
	List<Poem> selectByDynasty(String dynasty);

	/**
	 * 查询标题包含某个关键词的古诗词
	 * @param keyword
	 * @return
	 */
	@Select("SELECT * FROM poem WHERE title LIKE CONCAT('%', #{keyword}, '%') AND is_deleted = 0")
	List<Poem> selectByTitleKeyword(String keyword);

	/**
	 * 查询某个作者的古诗词数量
	 * @param author
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM poem WHERE author = #{author} AND is_deleted = 0")
	int countByAuthor(String author);

	/**
	 * 更新某个古诗词的内容
	 * @param id
	 * @param content
	 * @return
	 */
	@Update("UPDATE poem SET content = #{content} WHERE id = #{id} AND is_deleted = 0")
	int updateContentById(Long id, String content);

	/**
	 * 插入一条新的古诗词
	 * @param title
	 * @param author
	 * @param content
	 * @param dynasty
	 * @return
	 */
	@Insert("INSERT INTO poem (title, author, content, dynasty) VALUES (#{title}, #{author}, #{content}, #{dynasty})")
	int insertPoem(String title, String author, String content, String dynasty);

	/**
	 * 根据 ID 物理删除古诗词
	 * @param id
	 * @return
	 */
	@Delete("DELETE FROM poem WHERE id = #{id}")
	int deleteById(Long id);

	/**
	 * 根据作者逻辑删除古诗词
	 * @param author
	 * @return
	 */
	@Update("UPDATE poem SET is_deleted = 1 WHERE author = #{author}")
	int logicDeleteByAuthor(String author);

	/**
	 * 联合查询古诗词及其作者信息
	 * @param dynasty
	 * @return
	 */
	@Select("SELECT p.*, a.description AS author_description " +
			"FROM poem p " +
			"LEFT JOIN author a ON p.author = a.name " +
			"WHERE p.dynasty = #{dynasty} AND p.is_deleted = 0")
	List<Map<String, Object>> selectPoemWithAuthor(String dynasty);

	// 动态条件查询
	List<Poem> selectByCondition(@Param("title") String title,
	                             @Param("author") String author,
	                             @Param("dynasty") String dynasty);

	// 复杂条件查询
	List<Poem> selectByComplexCondition(@Param("title") String title,
	                                    @Param("author") String author);

	// 动态 WHERE 查询
	List<Poem> selectByWhereCondition(@Param("title") String title,
	                                  @Param("author") String author,
	                                  @Param("dynasty") String dynasty);

	// 动态更新
	int updatePoem(Poem poem);

	// 批量查询
	List<Poem> selectByIds(@Param("ids") List<Long> ids);

	// 自定义 TRIM 查询
	List<Poem> selectByTrimCondition(@Param("title") String title,
	                                 @Param("author") String author);
}