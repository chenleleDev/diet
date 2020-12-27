package com.javaclimb.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.User;
import com.javaclimb.mapper.UserMapper;
import com.javaclimb.service.UserService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 前端用户管理service实现类
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询前端用户列表
	 */
	@Override
	public ReturnDataForLayui getList(User user) {
		PageHelper.startPage(1, 1000);
		List<User> list = userMapper.getList(user);
		PageInfo<User> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条前端用户数据
	 */
	@Override
	public ReturnData add(User user) {
		User queryUser = new User();
		queryUser.setUsername(user.getUsername());
		List<User> list = userMapper.getList(queryUser);
		if(list!=null&&list.size()>0) {
			return ReturnData.fail("已有此用户名");
		}
		
		if(user.getState()==null) {
			user.setState(1);
		}
		computeIntake(user);		
		int i = userMapper.add(user);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 计算可摄取热量
	 */
	private void computeIntake(User user) {
		//可摄入热量的计算公式
		//男：10*体重（kg）+6.25*身高(cm)-5*年龄+5
		//女：10*体重（kg）+6.25*身高(cm)-5*年龄-161
		BigDecimal bigDecimal = new BigDecimal(0);
		if(user.getGender()==1) {
			bigDecimal = new BigDecimal(10*user.getWeight()+6.25*user.getHeight()-5*user.getAge()+5);
		}else {
			bigDecimal = new BigDecimal(10*user.getWeight()+6.25*user.getHeight()-5*user.getAge()-161);
		}
		user.setIntake(bigDecimal);
	}

	/**
	 * 删除一条前端用户数据
	 */
	@Override
	public ReturnData delete(User user) {
		int i = userMapper.delete(user);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条前端用户数据
	 */
	@Override
	public ReturnData update(User user) {
		computeIntake(user);
		int i = userMapper.update(user);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(User user) {
		int i = userMapper.updateState(user);
		return UpdateOrInsertResultDeal.dealWith(i);
	}
	
	
}
