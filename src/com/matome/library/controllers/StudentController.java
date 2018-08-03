package com.matome.library.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matome.library.model.Book;
import com.matome.library.model.Student;
import com.matome.library.services.StudentService;
import com.matome.library.services.UserService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;

	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return studentService.getAllStudents();
	}

	@PostMapping("/add")
	public void savePublisher(@RequestBody Student student) {
		studentService.addStudent(student);
	}

	@PutMapping("/issue-book")
	public void issueBook(@RequestBody Book book, @RequestParam("studentId") long studentId,
			@RequestParam("librarianId") long librarianId) {

		Student student = studentService.getStudentById(studentId);
		userService.issueBooks(student, book.getBookId(), librarianId);
	}
	
	@PutMapping("/return-book")
	public void returnBook(@RequestBody Student student, @RequestParam("bookId") long bookId) {
		userService.returnBooks(student, bookId);
	}
	
	@PutMapping("/pay-fine")
	public void payFine(@RequestBody Student student, @RequestParam("amount") double amount, @RequestParam("Date") Date payfinedate) {
		userService.payFine(amount, student, payfinedate);
	}

}
