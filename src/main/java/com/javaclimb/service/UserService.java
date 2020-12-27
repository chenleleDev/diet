package com.javaclimb.service;

import com.javaclimb.entity.User;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 前端用户管理service接口
 *
 */
public interface UserService {
	/**
	 * 查询前端用户列表
	 */
	public ReturnDataForLayui getList(User user);
	
	/**
	 * 增加一条前端用户数据
	 */
	public ReturnData add(User user);
	
	/**
	 * 删除一条前端用户数据
	 */
	public ReturnData delete(User user);
	
	/**
	 * 更新一条前端用户数据
	 */
	public ReturnData update(User user);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(User user);
	
	
}
