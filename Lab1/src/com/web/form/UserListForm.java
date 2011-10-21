package com.web.form;

import org.apache.struts.action.ActionForm;

public class UserListForm extends ActionForm {
	
	private  String [] userId;

	public String[] getUserId() {
		return userId;
	}

	public void setUserId(String[] userId) {
		this.userId = userId;
	}
	
	

}
