package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student>students;
	//define @PostConstruct to load student data only once
	//good way to initialize data
	@PostConstruct
	public void loadData() {
		students=new ArrayList<>();
		students.add(new Student("John","Doe"));
		students.add(new Student("John","Moe"));
		students.add(new Student("Joe","Dom"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {
		if(studentId>=students.size()||studentId<0) {
			throw new StudentNotFoundException("Student Id not found - "+studentId);
		}
		return students.get(studentId);
	}
	
	
}
