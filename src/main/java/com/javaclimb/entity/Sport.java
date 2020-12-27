package com.javaclimb.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 运动
 *
 */
@Data
public class Sport extends PageBean{
	
	private Integer id;	//主键id
	
	private String name;	//运动名称
	
	private String avatarUrl;	//图片地址
	
	private BigDecimal heat;	//热量
	
	private String des;			//简介
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间

}
