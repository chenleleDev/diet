package com.javaclimb.mapper;

import java.util.List;

import com.javaclimb.entity.Swiper;

/**
 * 推荐类型mapper
 *
 */
public interface SwiperMapper {
		
	/**
	 * 查询推荐类型列表
	 */
	public List<Swiper> getList(Swiper swiper);
	
	/**
	 * 增加一条推荐类型数据
	 */
	public int add(Swiper swiper);
	
	/**
	 * 删除一条推荐类型数据
	 */
	public int delete(Swiper swiper);
	
	/**
	 * 更新一条推荐类型数据
	 */
	public int update(Swiper swiper);
	
	/**
	 * 修改状态
	 */
	public int updateState(Swiper swiper);

}
