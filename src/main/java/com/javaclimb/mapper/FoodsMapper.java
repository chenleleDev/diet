package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.Foods;

/**
 * 食物mapper
 *
 */
public interface FoodsMapper {
		
	/**
	 * 查询食物列表
	 */
	public List<Foods> getList(Foods foods);
	
	/**
	 * 增加一条食物数据
	 */
	public int add(Foods foods);
	
	/**
	 * 删除一条食物数据
	 */
	public int delete(Foods foods);
	
	/**
	 * 更新一条食物数据
	 */
	public int update(Foods foods);
	
	/**
	 * 修改状态
	 */
	public int updateState(Foods foods);

}
