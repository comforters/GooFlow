package com.xx.ssm.entity;

public class UserInfo {
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", passWd=" + passWd + "]";
	}
	private int id;
	private String userName;
	private String passWd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
}
