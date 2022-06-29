package com.challenge.jdbc.dao;

import java.util.List;

import com.challenge.jdbc.entity.Student;

public interface StudentDao {
	
	public Student getStudent(int studentId);
	
	public List<Student> getAllStudents();
	
	public int insertStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudent(int studentId);


}
