package com.xx.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IAccountService;
import com.xx.ssm.service.IUserService;
import com.xx.ssm.web.model.PayModel;
@Controller
public class AccountController {
	public AccountController(){
		System.out.println("------AccountController¿ØÖÆÆ÷ÊµÀý»¯------");
	}
	@Autowired
	private IAccountService accountService;
	@RequestMapping("pay")
	public String pay(PayModel payModel){
		accountService.pay(payModel.getFromCardNo(),payModel.getToCardNo(), payModel.getMoney());
		return "paystatus";
	}
}
