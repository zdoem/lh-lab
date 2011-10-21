package com.web.form;

import org.apache.struts.action.ActionForm;

public class UserListForm extends ActionForm {
	
	private  int [] userId;
	private String cmd;
	
	

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int[] getUserId() {
		return userId;
	}

	public void setUserId(int[] userId) {
		this.userId = userId;
	}
	
	

}
