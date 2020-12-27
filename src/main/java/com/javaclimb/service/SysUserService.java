package com.javaclimb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.javaclimb.entity.SysUser;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 后台用户管理service接口
 *
 */
public interface SysUserService {
	/**
	 * 用户登录判断
	 */
	public ReturnData login(SysUser sysUser,HttpServletRequest request);
	
	/**
	 * 查询后台用户列表
	 */
	public ReturnDataForLayui getList(SysUser sysUser);
	
	/**
	 * 增加一条后台用户数据
	 */
	public ReturnData add(SysUser sysUser);
	
	/**
	 * 删除一条后台用户数据，假删除state=2
	 */
	public ReturnData delete(SysUser sysUser);
	
	/**
	 * 更新一条后台用户数据
	 */
	public ReturnData update(SysUser sysUser);
}
