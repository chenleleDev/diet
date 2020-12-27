package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.UserSport;
import com.javaclimb.service.UserSportService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 今日运动管理控制层
 *
 */
@Controller
@RequestMapping("/userSport")
public class UserSportController {
	
	@Autowired
	private UserSportService userSportService;
	
	/**
	 * 进入今日运动列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "userSport/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(UserSport userSport) {
		return userSportService.getList(userSport);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "userSport/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(UserSport userSport) {
		return userSportService.add(userSport);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "userSport/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(UserSport userSport) {
		return userSportService.update(userSport);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(UserSport userSport) {
		return userSportService.delete(userSport);
	}
}
