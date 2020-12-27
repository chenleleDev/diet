package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.SwiperFoods;
import com.javaclimb.service.SwiperFoodsService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 推荐饮食管理控制层
 *
 */
@Controller
@RequestMapping("/swiperFoods")
public class SwiperFoodsController {
	
	@Autowired
	private SwiperFoodsService swiperFoodsService;
	
	/**
	 * 进入推荐饮食列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "swiperFoods/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(SwiperFoods swiperFoods) {
		return swiperFoodsService.getList(swiperFoods);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "swiperFoods/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(SwiperFoods swiperFoods) {
		return swiperFoodsService.add(swiperFoods);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "swiperFoods/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(SwiperFoods swiperFoods) {
		return swiperFoodsService.update(swiperFoods);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(SwiperFoods swiperFoods) {
		return swiperFoodsService.delete(swiperFoods);
	}
}
