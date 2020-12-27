package com.javaclimb.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.StatisticsBean;
import com.javaclimb.entity.UserSport;
import com.javaclimb.mapper.UserSportMapper;
import com.javaclimb.service.UserSportService;
import com.javaclimb.util.CheckList;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 今日运动管理service实现类
 */
@Service
public class UserSportServiceImpl implements UserSportService{

	@Autowired
	private UserSportMapper userSportMapper;

	/**
	 * 查询今日运动列表
	 */
	@Override
	public ReturnDataForLayui getList(UserSport userSport) {
		PageHelper.startPage(userSport.getPage(), userSport.getLimit());
		List<UserSport> list = userSportMapper.getList(userSport);
		PageInfo<UserSport> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条今日运动数据
	 */
	@Override
	public ReturnData add(UserSport userSport) {
		//判断数据库里是不是已经添加了今日运动
		UserSport userSport_query = new UserSport(userSport.getUid(),userSport.getSid(),new Date());
		List<UserSport> list = userSportMapper.getList(userSport_query);
		if(!CheckList.isEmpty(list)) {
			return ReturnData.fail("今日已添加了该运动");
		}
		//保存到数据库
		int i = userSportMapper.add(userSport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 删除一条今日运动数据
	 */
	@Override
	public ReturnData delete(UserSport userSport) {
		int i = userSportMapper.delete(userSport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条今日运动数据
	 */
	@Override
	public ReturnData update(UserSport userSport) {		
		//更新数据库
		int i = userSportMapper.update(userSport);
		return ReturnData.success("绑定成功");
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(UserSport userSport) {
		int i = userSportMapper.updateState(userSport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 获取用户的今日摄取食物总热量
	 */
	@Override
	public BigDecimal getTodayTotalHeat(StatisticsBean statisticsBean) {		
		return userSportMapper.getTodayTotalHeat(statisticsBean);
	}
	
	
}
