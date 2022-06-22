package com.zensar.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
//@NamedQueries ( value= { @NamedQuery (name = "Student.check", query = "from Student s where s.studentName=?1")
//, @NamedQuery(name = "Student.check2", query = "from Student s where s.studentName=?1")})

//@NamedNativeQueries( value= {@NamedNativeQuery(
//		name = "Student.check",
//		query = "SELECT * FROM Student WHERE student_name like ?1", resultClass=Student.class 
//),
//		@NamedNativeQuery(
//				name = "Student.check2",
//				query = "SELECT * FROM Student WHERE student_name=?1 and student_age >?2", resultClass=Student.class 
//		)})


public class Student {
	@Id
	private int studentId;
	private String studentName;
	private int studentAge;
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
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
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge + "]";
	}
	
	

}
