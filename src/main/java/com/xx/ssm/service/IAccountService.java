package com.xx.ssm.service;

import java.util.List;

import com.xx.ssm.entity.UserInfo;

public interface IAccountService {
	public boolean pay(String fromCardNo,String toCardNo, String money);
}
