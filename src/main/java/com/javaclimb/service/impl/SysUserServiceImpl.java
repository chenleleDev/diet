package com.javaclimb.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaclimb.entity.SysUser;
import com.javaclimb.mapper.SysUserMapper;
import com.javaclimb.service.SysUserService;
import com.javaclimb.util.Consts;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 后台用户管理service实现
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public ReturnData login(SysUser sysUser, HttpServletRequest request) {
		ReturnData returnData = ReturnData.fail("登录失败");
		if(TextUtils.isEmpty(sysUser.getUsername())) {
			returnData = ReturnData.fail("用户名不能为空");
		}else if(TextUtils.isEmpty(sysUser.getPassword())) {
			returnData = ReturnData.fail("密码不能为空");
		}else {
			//根据username查询有没有后台管理用户
			SysUser dbUser = sysUserMapper.getUserByUserName(sysUser);
			if(dbUser==null) {
				returnData = ReturnData.fail("用户不存在");
			}else if(!dbUser.getPassword().equals(sysUser.getPassword())) {
				returnData = ReturnData.fail("密码错误");
			}else {
				request.getSession().setAttribute(Consts.USERINFO, dbUser);
				returnData = ReturnData.success("登录成功");
			}
		}
		
		return returnData;
	}

	@Override
	public ReturnDataForLayui getList(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnData add(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnData delete(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnData update(SysUser sysUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
