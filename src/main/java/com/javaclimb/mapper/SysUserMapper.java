package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.SysUser;

/**
 * 后台用户mapper
 *
 */
public interface SysUserMapper {
	
	/**
	 * 根据登录名查询SysUser对象
	 */
	public SysUser getUserByUserName(SysUser sysUser);
	
	/**
	 * 查询后台用户列表
	 */
	public List<SysUser> getList(SysUser sysUser);
	
	/**
	 * 增加一条后台用户数据
	 */
	public int add(SysUser sysUser);
	
	/**
	 * 删除一条后台用户数据，假删除state=2
	 */
	public int delete(SysUser sysUser);
	
	/**
	 * 更新一条后台用户数据
	 */
	public int update(SysUser sysUser);

}
