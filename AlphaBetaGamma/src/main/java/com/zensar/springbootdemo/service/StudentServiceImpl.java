package com.zensar.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.zensar.springbootdemo.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;
import com.zensar.springbootdemo.repository.StudentRepository;
import org.springframework.data.domain.Sort.Direction;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public StudentDto getStudent(int studentId) {
	
				
	// System.out.println("studentId" +studentId);
		
	Student student = studentRepository.findById(studentId).get();
			

			return modelMapper.map(student, StudentDto.class);
		
//		Student dto = mapToDto(student);
//		return student;
	}
	

	@Override
	public List<StudentDto> getAllStudents(int pageNumber , int pageSize, boolean order , String... properties) {
			
		List<StudentDto> listOfDtoStud= new ArrayList<StudentDto>();
		
		//Page<Student> listOfStud = studentRepository.findAll(PageRequest.of(pageNumber,	pageSize , Sort.by(Direction.DESC,"studentName") ));
		Page<Student> listOfStud = studentRepository.findAll(PageRequest.of(pageNumber,	pageSize , order ? Direction.ASC : Direction.DESC, properties) );

		List<Student> content= listOfStud.getContent();
		
		
		for(Student student: content) {
			listOfDtoStud.add(modelMapper.map(student, StudentDto.class));
		}
		
		return listOfDtoStud;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
//		Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student studentInsert = studentRepository.save(student);
//		studentDto.setStudentId(student.getStudentId());
//		studentDto.setStudentName(student.getStudentName());
//		studentDto.setStudentAge(student.getStudentAge());
		
		
		return modelMapper.map(studentInsert, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
					
//		Student student = mapToEntity(studentDto); codebypavan
		Student student = modelMapper.map(studentDto, Student.class);
		
		studentRepository.save(student);
		
		
		// Student studentDtoInsert = studentRepository.save(student2);
//		studentDto.setStudentId(student.getStudentId());
//		studentDto.setStudentName(student.getStudentName());
//		studentDto.setStudentAge(student.getStudentAge());
		return studentDto;
		
		
		
	}

	@Override
	public void deleteStudent(int studentId) {
		
		studentRepository.deleteById(studentId);
	}

	@Override
	public List<StudentDto> getByStudentName(String studentName) {
		// TODO Auto-generated method stub
//		return studentRepository.getByStudentName(studentName);
		List<Student> students= studentRepository.check(studentName);
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		
		for(Student student: students) {
		 studentDtos.add(modelMapper.map(student, StudentDto.class));
		}
		
		return studentDtos;
	}

	@Override
	public List<StudentDto> findByStudentNameAndAge(String studentName, int age) {
		// TODO Auto-generated method stub
		List<Student> students= studentRepository.check(studentName);
		List<StudentDto> studentDtos = new ArrayList<StudentDto>();
		
		for(Student student: students) {
		 studentDtos.add(modelMapper.map(student, StudentDto.class));
		}
		
		return studentDtos;
		
	}

//	@Override
//	public List<StudentDto> getAllStudents(int pageNumber, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}



//	@Override
//	public List<Student> findByStudentNameAndAge(String studentName, int age) {
//		// TODO Auto-generated method stub
//		return studentRepository.findByStudentNameAndStudentAge(studentName,age);
//	}
	
//	public Student mapToEntity(StudentDto studentDto ) {
//		codebypavan
//		Student student = new Student();
//		student.setStudentId(studentDto.getStudentId());
//		student.setStudentName(studentDto.getStudentName());
//		student.setStudentAge(studentDto.getStudentAge()) 	;
//		
//		return student;
//		
//	}
	
//	public Student mapToDto (Student student ) {
//		
//		Student dto = new Student();
//		dto.setStudentId(student.getStudentId());
//		dto.setStudentName(student.getStudentName());
//		dto.setStudentAge(student.getStudentAge()) 	;
//		
//		return dto;
//		
//	}


	
	
	
}




