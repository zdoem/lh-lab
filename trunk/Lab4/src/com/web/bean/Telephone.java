package com.web.bean;

import java.io.Serializable;

public class Telephone implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3857639878487927402L;
	private int userId;
	private String telNo;
	private User user;
	
	
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		//return userId;
		if(user!=null){
			return user.getUserId();
		}else{
			return userId;
		}
	}
	public void setUserId(int userId) {
		//this.userId = userId;
		if(user!=null){
			 user.setUserId(userId);
		}else{
			this.userId = userId;
		}
	}
	
	

}
