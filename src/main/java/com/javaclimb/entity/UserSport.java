package com.javaclimb.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 用户今日运动
 *
 */
@Data
public class UserSport extends PageBean{
	
	private Integer id;	//主键id	
	
	private Integer uid;	//用户id
	
	private Integer sid;	//运动id
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间	

	private String name;	//食物名称
	
	private String avatarUrl;	//食物图地址	
		
	private BigDecimal heat;	//运动热量
	
	private String des;		//运动简介
	
	private String userName;	//用户姓名
	
	private String userAvatarUrl;	//用户头像地址
	
	public UserSport() {
		
	}
	
	public UserSport(Integer uid,Integer sid,Date createTime) {
		this.uid = uid;
		this.sid = sid;
		this.createTime = createTime;
	}
	
}
