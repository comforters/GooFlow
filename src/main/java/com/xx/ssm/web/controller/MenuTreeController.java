package com.xx.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IAccountService;
import com.xx.ssm.service.IMenuTreeService;
import com.xx.ssm.service.IUserService;
import com.xx.ssm.web.model.PayModel;
@Controller
public class MenuTreeController {
	public MenuTreeController(){
		System.out.println("------TreeController¿ØÖÆÆ÷ÊµÀý»¯------");
	}
	@Autowired
	private IMenuTreeService menuTreeService;
	@RequestMapping("tree")
	public String tree(Model model){
		String menuTreeJson = menuTreeService.getMenuTreeJson(0);
		model.addAttribute("menuTreeJson", menuTreeJson);
		return  "tree_data";
		
	}
}
