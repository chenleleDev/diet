package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.UserFoods;
import com.javaclimb.service.UserFoodsService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 今日饮食管理控制层
 *
 */
@Controller
@RequestMapping("/userFoods")
public class UserFoodsController {
	
	@Autowired
	private UserFoodsService userFoodsService;
	
	/**
	 * 进入今日饮食列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "userFoods/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(UserFoods userFoods) {
		return userFoodsService.getList(userFoods);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "userFoods/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(UserFoods userFoods) {
		return userFoodsService.add(userFoods);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "userFoods/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(UserFoods userFoods) {
		return userFoodsService.update(userFoods);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(UserFoods userFoods) {
		return userFoodsService.delete(userFoods);
	}
}
