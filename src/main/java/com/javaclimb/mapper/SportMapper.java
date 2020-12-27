package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.Sport;

/**
 * 运动mapper
 *
 */
public interface SportMapper {
		
	/**
	 * 查询运动列表
	 */
	public List<Sport> getList(Sport foods);
	
	/**
	 * 增加一条运动数据
	 */
	public int add(Sport foods);
	
	/**
	 * 删除一条运动数据
	 */
	public int delete(Sport foods);
	
	/**
	 * 更新一条运动数据
	 */
	public int update(Sport foods);
	
	/**
	 * 修改状态
	 */
	public int updateState(Sport foods);

}
