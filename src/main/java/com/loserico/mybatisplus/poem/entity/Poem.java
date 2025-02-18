package com.loserico.mybatisplus.poem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("poem")
public class Poem {
	@TableId(type = IdType.AUTO)
	private Long id;

	private String title;
	private String author;
	private String content;
	private String dynasty;

	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

	@TableLogic
	private Integer isDeleted;
}