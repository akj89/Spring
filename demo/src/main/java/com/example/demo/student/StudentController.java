package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	private StudentService stuService;
	
	@Autowired
	public StudentController(StudentService stuService) {
		this.stuService = stuService;
	}

	@GetMapping(path = "/student")
	public List<Student> getStudentInfo()
	{
		return stuService.getStudents();
	}
	
	@PostMapping
	public void addNewStudent(@RequestBody Student student)
	{
		stuService.addNewStudent(student);
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId)
	{
		stuService.deleteStudent(studentId);
	}
	
}
