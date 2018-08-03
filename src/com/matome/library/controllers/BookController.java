package com.matome.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matome.library.model.Book;
import com.matome.library.services.BookService;


@RestController
@RequestMapping("books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public List<Book> findAllbooks() {
		return bookService.getAllBooks();
	}
	
	@PostMapping("/add")
	public void saveBooks(@RequestBody Book book) {
		bookService.addNewBooks(book);
	}
	
}
