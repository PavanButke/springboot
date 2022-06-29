package com.challenge.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.challenge.jdbc.dao.StudentDao;
import com.challenge.jdbc.entity.Student;



public class App {
	public static void main(String[] args) {
	
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("studentDao" , StudentDao.class);
		
//		List<Student> students = studentDao.getAllStudents();
//		for (Student s : students) {
//			System.out.println(s);
//		}
		
		
//		Student student = studentDao.getStudent(25);
//		System.out.println(student);

	


		
		Student student = new Student();
		student.setStudentId(21);
		student.setStudentName("Alpha");
		student.setRollNumber(25);

		int result = studentDao.insertStudent(student);

		System.out.println("You have added " + result+"student.");
		
		
	

//		Student student = new Student();
//		student.setStudentId(2);
//		student.setStudentName("Alpha");
//		student.setRollNumber(12);
//		System.out.println("Student Data"+result+ " Student");

		
//		int result = studentDao.deleteStudent(25);
//		System.out.println("Data of "+result+" Student Deleted");

	}
}
