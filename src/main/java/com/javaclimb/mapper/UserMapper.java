package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.User;

/**
 * 前端用户mapper
 *
 */
public interface UserMapper {	
	
	/**
	 * 查询前端用户列表
	 */
	public List<User> getList(User user);
	
	/**
	 * 增加一条前端用户数据
	 */
	public int add(User user);
	
	/**
	 * 删除一条前端用户数据，假删除state=2
	 */
	public int delete(User user);
	
	/**
	 * 更新一条前端用户数据
	 */
	public int update(User user);
	
	/**
	 * 修改一条前端用户状态
	 */
	public int updateState(User user);

}
