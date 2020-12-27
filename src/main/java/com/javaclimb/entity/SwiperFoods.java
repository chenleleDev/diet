package com.javaclimb.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 推荐饮食
 *
 */
@Data
public class SwiperFoods extends PageBean{
	
	private Integer id;	//主键id	
	
	private String name;	//轮播图名称
	
	private String avatarUrl;	//轮播图地址

	private Integer swiperid;	//轮播图id
	
	private Integer foodsid;	//食物id
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间
	
	private String foodsName;	//饮食名称
	
	private String foodsAvatarUrl;	//饮食图片地址
		
	private BigDecimal foodsHeat;	//饮食热量
	
	private String foodsDes;		//饮食简介
	
}
