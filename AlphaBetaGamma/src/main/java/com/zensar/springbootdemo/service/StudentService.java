package com.zensar.springbootdemo.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.zensar.springbootdemo.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;

public interface StudentService {
	
	public StudentDto getStudent(int studentId);
//	public List<StudentDto> getAllStudents(int pageNumber , int pageSize ,Sort sort);
	public StudentDto insertStudent(StudentDto studentDto);
	public StudentDto updateStudent(int studentId, StudentDto studentDto);
	public void deleteStudent(int studentId);
	List<StudentDto> getByStudentName(String studentName);
	List<StudentDto> findByStudentNameAndAge(String studentName, int age);
//	List<Student>findByStudentAgeOrderByStudentNameDesc(String studentName, int age);
//	public List<StudentDto> getAllStudents(int pageNumber, int pageSize, String studentName);
	public List<StudentDto> getAllStudents(int pageNumber, int pageSize, boolean order, String... properties);

}
