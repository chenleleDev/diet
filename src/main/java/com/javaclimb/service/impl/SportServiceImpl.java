package com.javaclimb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.Sport;
import com.javaclimb.mapper.SportMapper;
import com.javaclimb.service.SportService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 运动管理service实现类
 */
@Service
public class SportServiceImpl implements SportService{

	@Autowired
	private SportMapper sportMapper;

	/**
	 * 查询运动列表
	 */
	@Override
	public ReturnDataForLayui getList(Sport sport) {
		PageHelper.startPage(sport.getPage(), sport.getLimit());
		List<Sport> list = sportMapper.getList(sport);
		PageInfo<Sport> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条运动数据
	 */
	@Override
	public ReturnData add(Sport sport) {
		if(sport.getState()==null) {
			sport.setState(1);
		}
		int i = sportMapper.add(sport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 删除一条运动数据
	 */
	@Override
	public ReturnData delete(Sport sport) {
		int i = sportMapper.delete(sport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条运动数据
	 */
	@Override
	public ReturnData update(Sport sport) {
		int i = sportMapper.update(sport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(Sport sport) {
		int i = sportMapper.updateState(sport);
		return UpdateOrInsertResultDeal.dealWith(i);
	}
	
	
}
