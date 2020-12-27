package com.javaclimb.service;

import com.javaclimb.entity.Swiper;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 推荐类型管理service接口
 *
 */
public interface SwiperService {
	/**
	 * 查询推荐类型列表
	 */
	public ReturnDataForLayui getList(Swiper swiper);
	
	/**
	 * 增加一条推荐类型数据
	 */
	public ReturnData add(Swiper swiper);
	
	/**
	 * 删除一条推荐类型数据
	 */
	public ReturnData delete(Swiper swiper);
	
	/**
	 * 更新一条推荐类型数据
	 */
	public ReturnData update(Swiper swiper);
	
	/**
	 * 修改状态
	 */
	public ReturnData updateState(Swiper swiper);
	
	
}
