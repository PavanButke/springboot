package com.challenge.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.challenge.jdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Student getStudent(int studentId) {
		
		String query = "select * from student where studentId=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

		return student;
	}
	
	
	public List<Student> getAllStudents() {
		
		String query="select * from student";
		List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
	}


	public int insertStudent(Student student) {
		
		String query = "insert into student(studentId,studentName,rollNumber) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getStudentId(), student.getStudentName(), student.getRollNumber());
		return r;
	}

	public int updateStudent(Student student) {

		String query = "update student set studentName=? , rollNumber=? where studentId=?";
		int r = this.jdbcTemplate.update(query, student.getStudentName(), student.getRollNumber(), student.getStudentId());
		return r;
	}

	public int deleteStudent(int studentId) {
		
		String query = "delete from student where studentId=?";
		int r = this.jdbcTemplate.update(query, studentId);
		return r;
	}



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
