package com.javaclimb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.Swiper;
import com.javaclimb.mapper.SwiperMapper;
import com.javaclimb.service.SwiperService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 推荐类型管理service实现类
 */
@Service
public class SwiperServiceImpl implements SwiperService{

	@Autowired
	private SwiperMapper swiperMapper;

	/**
	 * 查询推荐类型列表
	 */
	@Override
	public ReturnDataForLayui getList(Swiper swiper) {
		PageHelper.startPage(swiper.getPage(), swiper.getLimit());
		List<Swiper> list = swiperMapper.getList(swiper);
		PageInfo<Swiper> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条推荐类型数据
	 */
	@Override
	public ReturnData add(Swiper swiper) {
		if(swiper.getState()==null) {
			swiper.setState(1);
		}
		int i = swiperMapper.add(swiper);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 删除一条推荐类型数据
	 */
	@Override
	public ReturnData delete(Swiper swiper) {
		int i = swiperMapper.delete(swiper);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条推荐类型数据
	 */
	@Override
	public ReturnData update(Swiper swiper) {
		int i = swiperMapper.update(swiper);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(Swiper swiper) {
		int i = swiperMapper.updateState(swiper);
		return UpdateOrInsertResultDeal.dealWith(i);
	}
	
	
}
