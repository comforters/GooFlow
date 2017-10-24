package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IUserInfoDao;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	public UserServiceImpl(){
		System.out.println("------ҵ���ʵ����------");
	}
	@Autowired
	private IUserInfoDao userInfoDAO;
	@Override
	public List<UserInfo> list() {
		return userInfoDAO.list();
	}
	public List<UserInfo> listPage(String name){
		return userInfoDAO.listPage(name);
	}
}
