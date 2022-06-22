package com.zensar.springbootdemo.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.zensar.springbootdemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
//	List<Student> getByStudentName(String studentName);
//	@Query("from Student s where s.studentName LIKE CONCAT('%',:studentName,'%')")
	
	
	@Query(value= "SELECT * FROM Student s WHERE s.student_name=:name", nativeQuery = true )
	List<Student> check(@Param("name") String studentName);
//	List<Student> check(@Param("name") String studentName, Sort sort);
	@Query("from Student s where s.studentName=?1 and s.studentAge=?2")
	List<Student> check2(@Param("name") String studentName, @Param("age") int age);
//	List<Student>findByStudentAgeOrderByStudentNameDesc(String studentName, int age);
}
