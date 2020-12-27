package com.javaclimb.service;

import com.javaclimb.entity.UserIntakeDaily;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 今日剩余可摄取热量管理service接口
 *
 */
public interface UserIntakeDailyService {
	/**
	 * 查询今日剩余可摄取热量列表
	 */
	public ReturnDataForLayui getList(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 增加一条今日剩余可摄取热量数据
	 */
	public ReturnData add(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 删除一条今日剩余可摄取热量数据
	 */
	public ReturnData delete(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 更新一条今日剩余可摄取热量数据
	 */
	public ReturnData update(UserIntakeDaily userIntakeDaily);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(UserIntakeDaily userIntakeDaily);
	
	
}
