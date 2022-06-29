package com.challenge.jdbc.entity;


public class Student {
	
	private int studentId;
	private String studentName;
	private int rollNumber;
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, int rollNumber) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.rollNumber = rollNumber;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", rollNumber=" + rollNumber + "]";
	}
	
	
	
}
