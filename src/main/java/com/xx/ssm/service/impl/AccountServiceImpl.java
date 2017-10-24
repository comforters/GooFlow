package com.xx.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IAccountDao;
import com.xx.ssm.entity.Account;
import com.xx.ssm.service.IAccountService;
@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private IAccountDao accountDAO;
	@Override
	public boolean pay(String fromCardNo, String toCardNo, String money) {
		Account from = new Account();
		from.setCardNo(fromCardNo);
		from.setSalay(Integer.parseInt(money)*-1 +"");
		
		Account to = new Account();
		to.setCardNo(toCardNo);
		to.setSalay(money);
		accountDAO.updateAccount(from);
		accountDAO.updateAccount(to);
		return true;
	}
}
