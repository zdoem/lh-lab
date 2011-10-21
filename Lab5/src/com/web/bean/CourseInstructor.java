package com.web.bean;

import java.io.Serializable;

public class CourseInstructor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6623415687031452747L;
	private String courseCode;
	private String instructorName;
	private String main;
	private int seq;
	private Course course;

	
	public String getCourseCode() {
		if(course!=null){
			return course.getCourseCode();
		}else{
			return courseCode;
		}
	}
	public void setCourseCode(String courseCode) {
		if(course!=null){
			 course.setCourseCode(courseCode);
		}else{
			this.courseCode = courseCode;
		}
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
