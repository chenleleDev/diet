package com.javaclimb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.Foods;
import com.javaclimb.mapper.FoodsMapper;
import com.javaclimb.service.FoodsService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 饮食管理service实现类
 */
@Service
public class FoodsServiceImpl implements FoodsService{

	@Autowired
	private FoodsMapper foodsMapper;

	/**
	 * 查询饮食列表
	 */
	@Override
	public ReturnDataForLayui getList(Foods foods) {
		PageHelper.startPage(foods.getPage(), foods.getLimit());
		List<Foods> list = foodsMapper.getList(foods);
		PageInfo<Foods> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条饮食数据
	 */
	@Override
	public ReturnData add(Foods foods) {
		if(foods.getState()==null) {
			foods.setState(1);
		}
		int i = foodsMapper.add(foods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 删除一条饮食数据
	 */
	@Override
	public ReturnData delete(Foods foods) {
		int i = foodsMapper.delete(foods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条饮食数据
	 */
	@Override
	public ReturnData update(Foods foods) {
		int i = foodsMapper.update(foods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(Foods foods) {
		int i = foodsMapper.updateState(foods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}
	
	
}
