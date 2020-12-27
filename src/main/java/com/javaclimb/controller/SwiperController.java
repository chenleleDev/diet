package com.javaclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.Swiper;
import com.javaclimb.service.SwiperService;
import com.javaclimb.util.ReturnData;
import com.javaclimb.util.ReturnDataForLayui;

/**
 * 推荐类型管理控制层
 *
 */
@Controller
@RequestMapping("/swiper")
public class SwiperController {
	
	@Autowired
	private SwiperService swiperService;
	
	/**
	 * 进入推荐类型列表页面
	 */
	@RequestMapping("/listPage")
	public String listPage() {
		return "swiper/list";
	}
	
	/**
	 * 列表查询
	 */
	@ResponseBody
	@RequestMapping("/getList")
	public ReturnDataForLayui getList(Swiper swiper) {
		return swiperService.getList(swiper);		
	}
	
	/**
	 * 进入添加页面
	 */
	@RequestMapping("/addPage")
	public String addPage() {
		return "swiper/add";
	}
	
	/**
	 * 执行添加操作
	 */
	@ResponseBody
	@RequestMapping("/add")
	public ReturnData add(Swiper swiper) {
		return swiperService.add(swiper);
	}

	/**
	 * 进入修改页面
	 */
	@RequestMapping("/editPage")
	public String editPage() {
		return "swiper/edit";
	}

	/**
	 * 执行修改操作
	 */
	@ResponseBody
	@RequestMapping("/update")
	public ReturnData update(Swiper swiper) {
		return swiperService.update(swiper);
	}
	
	/**
	 * 执行删除操作
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public ReturnData delete(Swiper swiper) {
		return swiperService.delete(swiper);
	}
}
