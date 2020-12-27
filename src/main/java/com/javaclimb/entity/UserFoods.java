package com.javaclimb.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 用户今日饮食
 *
 */
@Data
public class UserFoods extends PageBean{
	
	private Integer id;	//主键id	
	
	private Integer uid;	//用户id
	
	private Integer fid;	//食物id
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间	

	private String name;	//食物名称
	
	private String avatarUrl;	//食物图地址	
		
	private BigDecimal heat;	//饮食热量
	
	private String des;		//饮食简介
	
	private String userName;	//用户姓名
	
	private String userAvatarUrl;	//用户头像地址
	
	public UserFoods() {
		
	}
	
	public UserFoods(Integer uid,Integer fid,Date createTime) {
		this.uid = uid;
		this.fid = fid;
		this.createTime = createTime;
	}
	
}
