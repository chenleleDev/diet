package com.javaclimb.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.javaclimb.entity.StatisticsBean;
import com.javaclimb.entity.UserSport;

/**
 * 今日运动mapper
 *
 */
public interface UserSportMapper {
		
	/**
	 * 查询今日运动列表
	 */
	public List<UserSport> getList(UserSport userSport);
	
	/**
	 * 增加一条今日运动数据
	 */
	public int add(UserSport userSport);
	
	/**
	 * 删除一条今日运动数据
	 */
	public int delete(UserSport userSport);
	
	/**
	 * 更新一条今日运动数据
	 */
	public int update(UserSport userSport);
	
	/**
	 * 修改状态
	 */
	public int updateState(UserSport userSport);
	
	/**
	 * 获取用户的今日运动总热量
	 */
	public BigDecimal getTodayTotalHeat(StatisticsBean statisticsBean);

}
