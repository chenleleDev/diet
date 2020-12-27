package com.javaclimb.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 驼峰命名
 *	前端用户
 */
@Data
public class User extends PageBean{
	private Integer id;			//主键id
	
	private String username;	//登录名
	
	private String password;	//密码
	
	private String name;		//姓名
	
	private Integer gender;		//性别
		
	private Integer age;		//年龄
	
	private String avatarUrl;	//头像
	
	private String phone;		//电话
	
	private Integer height;		//身高
	
	private Integer weight;		//体重
	
	private String occupation;	//职业
	
	private BigDecimal intake;	//可摄入热量
	
	private String target;		//现阶段饮食目标
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间
}
