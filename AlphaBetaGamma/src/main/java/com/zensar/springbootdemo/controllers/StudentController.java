package com.zensar.springbootdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springbootdemo.dto.StudentDto;
import com.zensar.springbootdemo.entity.Student;
import com.zensar.springbootdemo.service.StudentService;

@RestController
@RequestMapping(value = "/student-api" )
public class StudentController {

	@Autowired
	private StudentService studentService;

	
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studentId") int studentId) {
//		studentService.getStudent(studentId);
		return new ResponseEntity<StudentDto>(studentService.getStudent(studentId), HttpStatus.OK);
	}

	// http://localhost:8080/students
	// @RequestMapping(value = { "/students", "/listOfStudents"
	// },method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listOfStudents" })
	public ResponseEntity< List<StudentDto>> getAllStudents(@RequestParam(value = "pageNumber", required = false ,defaultValue = "0")int pageNumber , @RequestParam(value = "pageSize" , required = false , defaultValue="3") int pageSize , @RequestParam(value = "order" , required = false , defaultValue = "true" ) boolean order, @RequestParam(value = "sort" , required = false , defaultValue = "studentName" ) String... properties) {
		return new ResponseEntity<List<StudentDto>>(studentService.getAllStudents(pageNumber,pageSize,order,properties),HttpStatus.OK);
	}
	

	// http://localhost:8080/students POST
	// @RequestMapping(value = "/students",method=RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		//studentService.insertStudent(studentDto);
		return new ResponseEntity<StudentDto>(studentService.insertStudent(studentDto), HttpStatus.CREATED);

	}/*codebypavan*/

	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		
		//studentService.updateStudent(studentId, studentDto);

		return new ResponseEntity<StudentDto>(studentService.insertStudent(studentDto), HttpStatus.CREATED);

	}

	// http://localhost:8080/students/1001 -> Delete
	//codebypavan
	// @RequestMapping(value="/students/{studentId}",method=RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return new ResponseEntity<String>("Student Deletion Performed", HttpStatus.OK);
	}

	@GetMapping("/students/name/{studentName}")
	public ResponseEntity<List<StudentDto>> getByStudentName(@PathVariable("studentName") String studentName) {
		return new ResponseEntity<List<StudentDto>>(studentService.getByStudentName(studentName), HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentName}/{studentAge}")
	public ResponseEntity<List<StudentDto>> findByStudentNameAndStudentAge(@PathVariable("studentName")String studentName,@PathVariable("studentAge") int age) {
		// TODO Auto-generated method stub
		return new ResponseEntity<List<StudentDto>>(studentService.findByStudentNameAndAge(studentName, age), HttpStatus.OK);
	}
	
	

}
