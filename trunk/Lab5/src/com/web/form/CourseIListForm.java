package com.web.form;

import com.dcs.strut.exten.ListForm;

public class CourseIListForm extends ListForm {
	private String sortColumn = "coursecode";
	private String[] delCourseCode;
	private String cmd;

	
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String[] getDelCourseCode() {
		return delCourseCode;
	}

	public void setDelCourseCode(String[] delCourseCode) {
		this.delCourseCode = delCourseCode;
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
