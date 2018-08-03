package com.matome.library.controllers;

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
import com.matome.library.model.Librarian;
import com.matome.library.model.Student;
import com.matome.library.services.LibrarianService;
import com.matome.library.services.StudentService;
import com.matome.library.services.UserService;

@RestController
@RequestMapping("librarian")
public class LibrarianController {
	
	@Autowired
	private LibrarianService librarianService;
	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/librarians")
	public List<Librarian> findAllLibrarians() {
		return librarianService.getAllLibrarians();
	}
	
	@PostMapping("/add")
	public void saveLibrarians(@RequestBody Librarian librarian) {
		librarianService.createLibrarian(librarian);
	}
	
	@PutMapping("/issue-book")
	public void issueBook(@RequestBody Book book, @RequestParam("studentId") long studentId,
			@RequestParam("librarianId") long librarianId) {

		Student student = studentService.getStudentById(studentId);
		userService.issueBooks(student, book.getBookId(), librarianId);
	}
	
	@PutMapping("/return-book")
	public <T> void returnBook(@RequestBody T user, @RequestParam("bookId") long bookId) {
		userService.returnBooks(user, bookId);
	}

}
