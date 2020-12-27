package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.UserIntakeDaily;

/**
 * 今日剩余可摄取热量mapper
 *
 */
public interface UserIntakeDailyMapper {
		
	/**
	 * 查询今日剩余可摄取热量列表
	 */
	public List<UserIntakeDaily> getList(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 增加一条今日剩余可摄取热量数据
	 */
	public int add(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 删除一条今日剩余可摄取热量数据
	 */
	public int delete(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 更新一条今日剩余可摄取热量数据
	 */
	public int update(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 修改状态
	 */
	public int updateState(UserIntakeDaily userIntakeDaily);

}
