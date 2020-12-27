package com.javaclimb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.javaclimb.entity.Foods;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 饮食管理service接口
 *
 */
public interface FoodsService {
	/**
	 * 查询饮食列表
	 */
	public ReturnDataForLayui getList(Foods foods);
	
	/**
	 * 增加一条饮食数据
	 */
	public ReturnData add(Foods foods);
	
	/**
	 * 删除一条饮食数据
	 */
	public ReturnData delete(Foods foods);
	
	/**
	 * 更新一条饮食数据
	 */
	public ReturnData update(Foods foods);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(Foods foods);
	
	
}
