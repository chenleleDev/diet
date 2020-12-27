package com.javaclimb.service;

import java.math.BigDecimal;

import com.javaclimb.entity.StatisticsBean;
import com.javaclimb.entity.UserFoods;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 今日饮食service接口
 *
 */
public interface UserFoodsService {
	/**
	 * 查询今日饮食列表
	 */
	public ReturnDataForLayui getList(UserFoods userFoods);
	
	/**
	 * 增加一条今日饮食数据
	 */
	public ReturnData add(UserFoods userFoods);
	
	/**
	 * 删除一条今日饮食数据
	 */
	public ReturnData delete(UserFoods userFoods);
	
	/**
	 * 更新一条今日饮食数据
	 */
	public ReturnData update(UserFoods userFoods);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(UserFoods userFoods);
	
	/**
	 * 获取用户的今日摄取食物总热量
	 */
	public BigDecimal getTodayTotalHeat(StatisticsBean statisticsBean);
	
}
