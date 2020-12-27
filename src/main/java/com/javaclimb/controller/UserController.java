package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.User;
import com.javaclimb.service.UserService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 前端用户管理控制层
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 进入前端用户列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "user/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(User user) {
		return userService.getList(user);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "user/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(User user) {
		return userService.add(user);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "user/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(User user) {
		return userService.update(user);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(User user) {
		return userService.delete(user);
	}
}
