package com.javaclimb.entity;

import java.util.Date;

import lombok.Data;

/**
 * 推荐类型
 *
 */
@Data
public class Swiper extends PageBean{
	
	private Integer id;	//主键id
	
	private String name;	//标题
	
	private String avatarUrl;	//图片地址
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间

}
