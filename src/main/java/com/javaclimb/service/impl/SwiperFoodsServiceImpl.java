package com.javaclimb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.entity.Foods;
import com.javaclimb.entity.Swiper;
import com.javaclimb.entity.SwiperFoods;
import com.javaclimb.mapper.FoodsMapper;
import com.javaclimb.mapper.SwiperFoodsMapper;
import com.javaclimb.mapper.SwiperMapper;
import com.javaclimb.service.SwiperFoodsService;
import com.javaclimb.util.CheckList;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;
import com.javaclimb.util.UpdateOrInsertResultDeal;

/**
 * 推荐饮食管理service实现类
 */
@Service
public class SwiperFoodsServiceImpl implements SwiperFoodsService{

	@Autowired
	private SwiperFoodsMapper swiperFoodsMapper;
	@Autowired
	private FoodsMapper foodsMapper;
	@Autowired
	private SwiperMapper swiperMapper;

	/**
	 * 查询推荐饮食列表
	 */
	@Override
	public ReturnDataForLayui getList(SwiperFoods swiperFoods) {
		PageHelper.startPage(swiperFoods.getPage(), swiperFoods.getLimit());
		List<SwiperFoods> list = swiperFoodsMapper.getList(swiperFoods);
		PageInfo<SwiperFoods> info = new PageInfo<>(list);
		return ReturnDataForLayui.success(list, info.getTotal());
	}

	/**
	 * 增加一条推荐饮食数据
	 */
	@Override
	public ReturnData add(SwiperFoods swiperFoods) {
		//判断数据库里是不是已经有了推荐饮食的对应关系
		List<SwiperFoods> list = swiperFoodsMapper.getList(swiperFoods);
		if(!CheckList.isEmpty(list)) {
			return ReturnData.fail("该推荐已经与食物做了绑定，不能重复绑定！");
		}
		//获取食物
		Foods foods = new Foods();
		foods.setId(swiperFoods.getFoodsid());
		Foods dbFoods = foodsMapper.getList(foods).get(0);
		swiperFoods.setFoodsName(dbFoods.getName());
		swiperFoods.setFoodsAvatarUrl(dbFoods.getAvatarUrl());
		swiperFoods.setFoodsDes(dbFoods.getDes());
		swiperFoods.setFoodsHeat(dbFoods.getHeat());
		//获取推荐
		Swiper swiper = new Swiper();
		swiper.setId(swiperFoods.getSwiperid());
		Swiper dbSwiper = swiperMapper.getList(swiper).get(0);
		swiperFoods.setName(dbSwiper.getName());
		swiperFoods.setAvatarUrl(dbSwiper.getAvatarUrl());	
		//保存到数据库
		int i = swiperFoodsMapper.add(swiperFoods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 删除一条推荐饮食数据
	 */
	@Override
	public ReturnData delete(SwiperFoods swiperFoods) {
		int i = swiperFoodsMapper.delete(swiperFoods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}

	/**
	 * 更新一条推荐饮食数据
	 */
	@Override
	public ReturnData update(SwiperFoods swiperFoods) {
		SwiperFoods querySwiperFoods = new SwiperFoods();
		querySwiperFoods.setSwiperid(swiperFoods.getSwiperid());
		querySwiperFoods.setFoodsid(swiperFoods.getFoodsid());		
		//判断数据库里是不是已经有了推荐饮食的对应关系
		List<SwiperFoods> list = swiperFoodsMapper.getList(querySwiperFoods);
		if(!CheckList.isEmpty(list)) {
			SwiperFoods dbInfo = list.get(0);
			if(dbInfo.getId()==swiperFoods.getId()) {
				return ReturnData.success("绑定成功");
			}else {
				return ReturnData.fail("该推荐已经与食物做了绑定，不能重复绑定！");
			}
		}
		//获取食物
		Foods foods = new Foods();
		foods.setId(swiperFoods.getFoodsid());
		Foods dbFoods = foodsMapper.getList(foods).get(0);
		swiperFoods.setFoodsName(dbFoods.getName());
		swiperFoods.setFoodsAvatarUrl(dbFoods.getAvatarUrl());
		swiperFoods.setFoodsDes(dbFoods.getDes());
		swiperFoods.setFoodsHeat(dbFoods.getHeat());
		//获取推荐
		Swiper swiper = new Swiper();
		swiper.setId(swiperFoods.getSwiperid());
		Swiper dbSwiper = swiperMapper.getList(swiper).get(0);
		swiperFoods.setName(dbSwiper.getName());
		swiperFoods.setAvatarUrl(dbSwiper.getAvatarUrl());	
		
		//更新数据库
		int i = swiperFoodsMapper.update(swiperFoods);
		return ReturnData.success("绑定成功");
	}

	/**
	 * 修改状态
	 */
	@Override
	public ReturnData updateState(SwiperFoods swiperFoods) {
		int i = swiperFoodsMapper.updateState(swiperFoods);
		return UpdateOrInsertResultDeal.dealWith(i);
	}
	
	
}
