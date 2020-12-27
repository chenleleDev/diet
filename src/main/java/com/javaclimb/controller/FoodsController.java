package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.Foods;
import com.javaclimb.service.FoodsService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 饮食管理控制层
 *
 */
@Controller
@RequestMapping("/foods")
public class FoodsController {
	
	@Autowired
	private FoodsService foodsService;
	
	/**
	 * 进入饮食列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "foods/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(Foods foods) {
		return foodsService.getList(foods);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "foods/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(Foods foods) {
		return foodsService.add(foods);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "foods/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(Foods foods) {
		return foodsService.update(foods);
	}
	
	/**
	 * 申请通过
	 */
	@ResponseBody
	@RequestMapping("/updateState")
	public ReturnData updateState(Foods foods) {
		return foodsService.updateState(foods);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(Foods foods) {
		return foodsService.delete(foods);
	}
}
