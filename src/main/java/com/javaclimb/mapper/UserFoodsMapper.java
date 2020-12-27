package com.javaclimb.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.javaclimb.entity.StatisticsBean;
import com.javaclimb.entity.UserFoods;

/**
 * 今日饮食mapper
 *
 */
public interface UserFoodsMapper {
		
	/**
	 * 查询今日饮食列表
	 */
	public List<UserFoods> getList(UserFoods userFoods);
	
	/**
	 * 增加一条今日饮食数据
	 */
	public int add(UserFoods userFoods);
	
	/**
	 * 删除一条今日饮食数据
	 */
	public int delete(UserFoods userFoods);
	
	/**
	 * 更新一条今日饮食数据
	 */
	public int update(UserFoods userFoods);
	
	/**
	 * 修改状态
	 */
	public int updateState(UserFoods userFoods);
	
	/**
	 * 获取用户的今日摄取食物总热量
	 */
	public BigDecimal getTodayTotalHeat(StatisticsBean statisticsBean);

}
