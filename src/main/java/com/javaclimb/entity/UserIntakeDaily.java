package com.javaclimb.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 今日剩余可摄取热量
 *
 */
@Data
public class UserIntakeDaily extends PageBean{
	
	private Integer id;	//主键id
	
	private Integer uid;	//用户id
	
	private BigDecimal intake;	//可摄取热量
	
	private Date insertDate;	//插入时间
	
	private Integer state;		//状态 1有效
	
	private Date createTime;	//创建时间
	
	private Date updateTime;	//修改时间

}
