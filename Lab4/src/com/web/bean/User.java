package com.web.bean;

import java.util.Set;

public class User {
	
	private int userId;
	private String username;
	private String firstname;
	private String lastname;
	private String email; 
	private String address;
	private String sex;
	private Set<Telephone> telephone;
	
	
	public Set<Telephone> getTelephone() {
		return telephone;
	}
	public void setTelephone(Set<Telephone> telephone) {
		this.telephone = telephone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
