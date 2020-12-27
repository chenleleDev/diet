package com.javaclimb.service;

import com.javaclimb.entity.SwiperFoods;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 推荐饮食service接口
 *
 */
public interface SwiperFoodsService {
	/**
	 * 查询推荐饮食列表
	 */
	public ReturnDataForLayui getList(SwiperFoods swiperFoods);
	
	/**
	 * 增加一条推荐饮食数据
	 */
	public ReturnData add(SwiperFoods swiperFoods);
	
	/**
	 * 删除一条推荐饮食数据
	 */
	public ReturnData delete(SwiperFoods swiperFoods);
	
	/**
	 * 更新一条推荐饮食数据
	 */
	public ReturnData update(SwiperFoods swiperFoods);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(SwiperFoods swiperFoods);
	
	
}
