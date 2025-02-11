package com.school.school.services;

import com.school.school.dtos.StudentResponse;
import com.school.school.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public List<StudentResponse> getAllStudents() {
		return repository.findAll()
				       .stream()
				       .map(
													student -> new StudentResponse(
															student.getId(),
															student.getName(),
															student.getAge()
													)
				       )
				       .collect(Collectors.toList());
	}
}
