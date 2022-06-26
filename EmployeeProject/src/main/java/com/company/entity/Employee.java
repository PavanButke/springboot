package com.company.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Employee {

	@Id
	private int empId;
	private String empName;
	private String empDept;
	
	
	
}
