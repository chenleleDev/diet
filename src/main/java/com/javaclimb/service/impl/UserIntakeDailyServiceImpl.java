package com.javaclimb.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.UserIntakeDaily;
import com.javaclimb.mapper.UserIntakeDailyMapper;
import com.javaclimb.service.UserIntakeDailyService;
import com.javaclimb.util.CheckList;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 今日剩余可摄取热量管理service实现类
 */
@Service
public class UserIntakeDailyServiceImpl implements UserIntakeDailyService{

	@Autowired
	private UserIntakeDailyMapper userIntakeDailyMapper;

	/**
	 * 查询今日剩余可摄取热量列表
	 */
	@Override
	public ReturnDataForLayui getList(UserIntakeDaily userIntakeDaily) {
		PageHelper.startPage(userIntakeDaily.getPage(), userIntakeDaily.getLimit());
		List<UserIntakeDaily> list = userIntakeDailyMapper.getList(userIntakeDaily);
		PageInfo<UserIntakeDaily> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条今日剩余可摄取热量数据
	 */
	@Override
	public ReturnData add(UserIntakeDaily userIntakeDaily) {
		//判断今日是否已增加
		UserIntakeDaily userIntakeDaily_query = new UserIntakeDaily();
		userIntakeDaily_query.setInsertDate(new Date());
		userIntakeDaily_query.setUid(userIntakeDaily.getUid());
		List<UserIntakeDaily> list = userIntakeDailyMapper.getList(userIntakeDaily_query);
		if(CheckList.isEmpty(list)) {
			int i = userIntakeDailyMapper.add(userIntakeDaily);
		}else {
			//更新
			UserIntakeDaily dbUserIntakeDaily = list.get(0);
			dbUserIntakeDaily.setIntake(userIntakeDaily.getIntake());
			update(dbUserIntakeDaily);
		}
		
		return ReturnData.success();
	}

	/**
	 * 删除一条今日剩余可摄取热量数据
	 */
	@Override
	public ReturnData delete(UserIntakeDaily userIntakeDaily) {
		int i = userIntakeDailyMapper.delete(userIntakeDaily);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条今日剩余可摄取热量数据
	 */
	@Override
	public ReturnData update(UserIntakeDaily userIntakeDaily) {
		int i = userIntakeDailyMapper.update(userIntakeDaily);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(UserIntakeDaily userIntakeDaily) {
		int i = userIntakeDailyMapper.updateState(userIntakeDaily);
		return UpdateOrInsertResultDeal.dealWith(i);
	}
	
	
}
