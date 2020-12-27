package com.javaclimb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaclimb.entity.SysUser;
import com.javaclimb.service.SysUserService;
import com.javaclimb.util.Consts;
import com.javaclimb.util.ReturnData;

/**
 * 后台管理登录controller
 */
@Controller
public class LoginController {
	
	@Autowired
	private SysUserService sysUserService;
    
	/**
	 *  默认首页
	 *  直接转向登陆页面
	 * @return
	 */
    @RequestMapping("/")
    public String rootUrl() {
        return "redirect:login";
    }
    /**
     * 返回登录页面
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	SysUser sysUser = (SysUser) session.getAttribute(Consts.USERINFO);
    	if(sysUser!=null) {
    		return "redirect:index";
    	}
        return "login";
    }
    /**
     * 登录请求
     * @param request
     * @param loginSysUser
     * @return
     */
    @RequestMapping("requestLogin")
    @ResponseBody
    public ReturnData requestLogin(HttpServletRequest request,SysUser loginSysUser) {
    	HttpSession session = request.getSession();
    	SysUser sysUser = (SysUser) session.getAttribute(Consts.USERINFO);
    	if(sysUser!=null) {
    		return ReturnData.success("登录成功");
    	}
    	return sysUserService.login(loginSysUser, request);
    }
    
    /**
     * 后台管理首页
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	SysUser sysUser = (SysUser) session.getAttribute(Consts.USERINFO);
    	if(sysUser==null) {
    		return "redirect:login";
    	}
        return "index";
    }
    
    /**
     * 退出
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
    	request.getSession().setAttribute(Consts.USERINFO, null);
    	return "redirect:login";
    }
    
    
}
