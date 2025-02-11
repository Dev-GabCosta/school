package com.school.school.controllers;

import com.school.school.dtos.StudentResponse;
import com.school.school.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class StudentController {
	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<StudentResponse>> getAllStudents(){
		List<StudentResponse> students = service.getAllStudents();
		return  ResponseEntity.status(HttpStatus.OK).body(students);
	}
}
