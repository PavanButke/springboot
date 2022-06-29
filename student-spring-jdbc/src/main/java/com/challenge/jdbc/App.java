package com.challenge.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/challenge/jdbc/config.xml");
        
       JdbcTemplate template =context.getBean("jdbcTemplate", JdbcTemplate.class);
       
       String query = "insert into student(studentId , studentName , rollNumber) values(?,?,?)";
    
       int fall = template.update(query, 89 , "Pavan Butke", 122);
     
       System.out.println("Data Inserted -->"+ fall);
    }
}
