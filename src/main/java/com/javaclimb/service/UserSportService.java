package com.javaclimb.service;

import java.math.BigDecimal;

import com.javaclimb.entity.StatisticsBean;
import com.javaclimb.entity.UserSport;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 今日运动service接口
 *
 */
public interface UserSportService {
	/**
	 * 查询今日运动列表
	 */
	public ReturnDataForLayui getList(UserSport userSport);
	
	/**
	 * 增加一条今日运动数据
	 */
	public ReturnData add(UserSport userSport);
	
	/**
	 * 删除一条今日运动数据
	 */
	public ReturnData delete(UserSport userSport);
	
	/**
	 * 更新一条今日运动数据
	 */
	public ReturnData update(UserSport userSport);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(UserSport userSport);
	
	/**
	 * 获取用户的今日摄取食物总热量
	 */
	public BigDecimal getTodayTotalHeat(StatisticsBean statisticsBean);
	
}
