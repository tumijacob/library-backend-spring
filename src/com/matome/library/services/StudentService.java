package com.matome.library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.library.model.Student;
import com.matome.library.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll()
		    .forEach(students::add);
		return students;
	}
	
	public Student getStudentById(Long id) {
		return studentRepository.findOne(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Student updateStudent(Long id, Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(long id) {
		studentRepository.delete(id);
	}

}
