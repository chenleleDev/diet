package com.javaclimb.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 用户的总热量
 *
 */
@Data
public class StatisticsBean {
	private BigDecimal total;	//总热量
	private Integer uid;		//用户id
}
