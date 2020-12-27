package com.javaclimb.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.javaclimb.entity.StatisticsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.UserFoods;
import com.javaclimb.mapper.UserFoodsMapper;
import com.javaclimb.service.UserFoodsService;
import com.javaclimb.util.CheckList;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 今日饮食管理service实现类
 */
@Service
public class UserFoodsServiceImpl implements UserFoodsService{

	@Autowired
	private UserFoodsMapper userFoodsMapper;

	/**
	 * 查询今日饮食列表
	 */
	@Override
	public ReturnDataForLayui getList(UserFoods userFoods) {
		PageHelper.startPage(userFoods.getPage(), userFoods.getLimit());
		List<UserFoods> list = userFoodsMapper.getList(userFoods);
		PageInfo<UserFoods> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条今日饮食数据
	 */
	@Override
	public ReturnData add(UserFoods userFoods) {
		//判断数据库里是不是已经添加了今日饮食
		UserFoods userFoods_query = new UserFoods(userFoods.getUid(),userFoods.getFid(),new Date());
		List<UserFoods> list = userFoodsMapper.getList(userFoods_query);
		if(!CheckList.isEmpty(list)) {
			return ReturnData.fail("今日已添加了该食物");
		}
		//保存到数据库
		int i = userFoodsMapper.add(userFoods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 删除一条今日饮食数据
	 */
	@Override
	public ReturnData delete(UserFoods userFoods) {
		int i = userFoodsMapper.delete(userFoods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条今日饮食数据
	 */
	@Override
	public ReturnData update(UserFoods userFoods) {		
		//更新数据库
		int i = userFoodsMapper.update(userFoods);
		return ReturnData.success("绑定成功");
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(UserFoods userFoods) {
		int i = userFoodsMapper.updateState(userFoods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 获取用户的今日摄取食物总热量
	 */
	@Override
	public BigDecimal getTodayTotalHeat(StatisticsBean statisticsBean) {
		return userFoodsMapper.getTodayTotalHeat(statisticsBean);
	}
	
	
}
