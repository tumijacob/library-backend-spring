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
import com.matome.library.model.Faculty;
import com.matome.library.services.FacultyService;
import com.matome.library.services.UserService;

@RestController
@RequestMapping("faculty")
public class FacultyController {
	
	@Autowired
	private FacultyService facultyService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/faculties")
	public List<Faculty> getAllFaculties() {
		return facultyService.getAllFaculties();
	}
	
	@PostMapping("/add")
	public void addFaculty(@RequestBody Faculty faculty) {
		facultyService.addFaculty(faculty);
	}
	
	@PutMapping("/issue-book")
	public void issueBook(@RequestBody Book book, @RequestParam("facultyId") long facultyId,
			@RequestParam("librarianId") long librarianId) {

		Faculty faculty = facultyService.getFacultyById(facultyId);
		userService.issueBooks(faculty, book.getBookId(), librarianId);
	}
	
	@PutMapping("/return-book")
	public void returnBook(@RequestBody Faculty faculty, @RequestParam("bookId") long bookId) {
		userService.returnBooks(faculty, bookId);
	}

}
