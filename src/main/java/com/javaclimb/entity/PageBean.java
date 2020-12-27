package com.javaclimb.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 分页实体类
 *
 */
@Data
public class PageBean implements Serializable{
	/**
	 * 当前第几页
	 */
	private Integer page;
	/**
	 * 页面大小
	 */
	private Integer limit;
	
	/**
	 * 搜索内容
	 */
	private String searchContent;
}
