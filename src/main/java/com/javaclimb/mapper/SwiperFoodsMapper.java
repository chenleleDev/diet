package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.SwiperFoods;

/**
 * 推荐饮食mapper
 *
 */
public interface SwiperFoodsMapper {
		
	/**
	 * 查询推荐饮食列表
	 */
	public List<SwiperFoods> getList(SwiperFoods swiperFoods);
	
	/**
	 * 增加一条推荐饮食数据
	 */
	public int add(SwiperFoods swiperFoods);
	
	/**
	 * 删除一条推荐饮食数据
	 */
	public int delete(SwiperFoods swiperFoods);
	
	/**
	 * 更新一条推荐饮食数据
	 */
	public int update(SwiperFoods swiperFoods);
	
	/**
	 * 修改状态
	 */
	public int updateState(SwiperFoods swiperFoods);

}
