package com.xx.ssm.service;

import java.util.List;

import com.xx.ssm.entity.UserInfo;

public interface IUserService {
	public List<UserInfo> list();
	public List<UserInfo> listPage(String name);
}
