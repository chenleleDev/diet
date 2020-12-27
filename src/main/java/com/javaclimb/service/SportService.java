package com.javaclimb.service;

import com.javaclimb.entity.Sport;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 运动管理service接口
 *
 */
public interface SportService {
	/**
	 * 查询运动列表
	 */
	public ReturnDataForLayui getList(Sport sport);
	
	/**
	 * 增加一条运动数据
	 */
	public ReturnData add(Sport sport);
	
	/**
	 * 删除一条运动数据
	 */
	public ReturnData delete(Sport sport);
	
	/**
	 * 更新一条运动数据
	 */
	public ReturnData update(Sport sport);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(Sport sport);
	
	
}
