package com.xx.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.ssm.entity.PageBean;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IUserService;
@Controller
public class UserInfoController {
	public UserInfoController(){
		System.out.println("------UserInfoController控制器实例化------");
	}
	@Autowired
	private IUserService userService;
	@RequestMapping("index")
	public String index(Model model){
		List<UserInfo> list= userService.list();
		model.addAttribute("list", list);
		return "index";
	}
	@RequestMapping("page")
	public String page(PageBean pageBean,Model model){
		PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
		/*
		// 条件查询分页
		List<UserInfo> list= userService.listPage("w");
		for (UserInfo userInfo : list) {
			System.out.println(userInfo);
		}
		*/
		List<UserInfo> list= userService.list();
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list", list);
		return "page";
	}
	
}
