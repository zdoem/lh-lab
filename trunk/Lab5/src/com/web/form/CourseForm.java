package com.web.form;

import java.util.Date;
import org.apache.struts.action.ActionForm;

import com.dcs.strut.exten.DetailForm;
public class CourseForm  extends DetailForm{
	
	private String courseCode;
	private String courseName;
	private String overView;
	private int courseLevel;
	private int duration;
	private int target;
	private String location;
	private String clanguage;
	private  int fee;
	private String payment;
	private String remark;
	private String ddate;
	//private String cmd;
	private String itemData;
	


	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getItemData() {
		return itemData;
	}
	public void setItemData(String itemData) {
		this.itemData = itemData;
	}
	public String getClanguage() {
		return clanguage;
	}
	public void setClanguage(String clanguage) {
		this.clanguage = clanguage;
	}
	//public String getCmd() {
	//	return cmd;
	//}
	//public void setCmd(String cmd) {
	//	this.cmd = cmd;
	//}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(int courseLevel) {
		this.courseLevel = courseLevel;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	
	
	public void loadFromBean(Object o) {
		// TODO Auto-generated method stub
		
	}
	public void loadToBean(Object o) {
		// TODO Auto-generated method stub
		
	}

}
