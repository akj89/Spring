package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private StudentRepository stuRepo;
	
	@Autowired
	public StudentService(StudentRepository studentRepo)
	{
		this.stuRepo = studentRepo;
	}
	
	public List<Student> getStudents()
	{
		return stuRepo.findAll();
	}
	
	public void addNewStudent(Student student)
	{
		Optional<Student> studentsByEmail = stuRepo.findStudentByEmail(student.getEmailId());
		if( studentsByEmail.isPresent())
		{
			throw new IllegalStateException("email taken");
		}
		stuRepo.save(student);
		System.out.println(student);
	}
	
	public void deleteStudent(Long studentId)
	{
		boolean exists = stuRepo.existsById(studentId);
		if(!exists)
		{
			throw new IllegalStateException("Studen with id "+ studentId + " does not exist");
		}
		stuRepo.deleteById(studentId);
	}
}
