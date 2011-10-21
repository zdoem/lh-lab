package com.web.form;

import com.dcs.strut.exten.ListForm;

public class UserlListForm extends ListForm{
	
	private String sortColumn = "userId";
	private int[] delUserId;
	private String cmd;
	

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int[] getDelUserId() {
		return delUserId;
	}

	public void setDelUserId(int[] delUserId) {
		this.delUserId = delUserId;
	}

	public String getSortColumn() {
		// TODO Auto-generated method stub
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		// TODO Auto-generated method stub
		this.sortColumn = sortColumn;
	}

}
