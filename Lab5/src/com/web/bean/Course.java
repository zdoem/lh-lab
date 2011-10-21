package com.web.bean;

import java.util.Date;
import java.util.List;


public class Course {
	private String courseCode;
	private String courseName;
	private String overView;
	private int courseLevel;
	private int duration;
	private int target;
	private String location;
	private String clanguage;
	private int fee;
	private String payment;
	private String remark;
	private Date updateDay;
	private List<CourseInstructor> coursIns;
	
	
	public List<CourseInstructor> getCoursIns() {
		return coursIns;
	}
	public void setCoursIns(List<CourseInstructor> coursIns) {
		this.coursIns = coursIns;
	}
	public String getClanguage() {
		return clanguage;
	}
	public void setClanguage(String clanguage) {
		this.clanguage = clanguage;
	}
	public String getCourseCode() {
		return courseCode.trim();
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
	public Date getUpdateDay() {
		return updateDay;
	}
	public void setUpdateDay(Date updateDay) {
		this.updateDay = updateDay;
	}

}
