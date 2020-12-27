package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.UserIntakeDaily;
import com.javaclimb.service.UserIntakeDailyService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 今日剩余可摄取热量管理控制层
 *
 */
@Controller
@RequestMapping("/userIntakeDaily")
public class UserIntakeDailyController {
	
	@Autowired
	private UserIntakeDailyService userIntakeDailyService;
	
	/**
	 * 进入今日剩余可摄取热量列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "userIntakeDaily/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(UserIntakeDaily userIntakeDaily) {
		return userIntakeDailyService.getList(userIntakeDaily);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "userIntakeDaily/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(UserIntakeDaily userIntakeDaily) {
		return userIntakeDailyService.add(userIntakeDaily);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "userIntakeDaily/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(UserIntakeDaily userIntakeDaily) {
		return userIntakeDailyService.update(userIntakeDaily);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(UserIntakeDaily userIntakeDaily) {
		return userIntakeDailyService.delete(userIntakeDaily);
	}
}
