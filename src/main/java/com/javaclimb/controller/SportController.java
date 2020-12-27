package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.Sport;
import com.javaclimb.service.SportService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 运动管理控制层
 *
 */
@Controller
@RequestMapping("/sport")
public class SportController {
	
	@Autowired
	private SportService sportService;
	
	/**
	 * 进入运动列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "sport/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(Sport sport) {
		return sportService.getList(sport);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "sport/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(Sport sport) {
		return sportService.add(sport);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "sport/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(Sport sport) {
		return sportService.update(sport);
	}
	
	/**
	 * 审核
	 */
	@ResponseBody
	@RequestMapping("/updateState")
	public ReturnData updateState(Sport sport) {
		return sportService.updateState(sport);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(Sport sport) {
		return sportService.delete(sport);
	}
}
