package com.javaclimb.entity;

import java.util.Date;

import lombok.Data;

/**
 * 驼峰命名
 *	后台用户登录表
 */
@Data
public class SysUser extends PageBean{
	private Integer id;			//主键id
	
	private String username;	//登录名
	
	private String password;	//密码
	
	private String name;		//姓名
	
	private Integer sex;		//性别
	
	private Integer age;		//年龄
	
	private String avatarUrl;	//头像
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间
}
