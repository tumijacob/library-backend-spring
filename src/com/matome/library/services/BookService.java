package com.matome.library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.library.model.Book;
import com.matome.library.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll()
		    .forEach(books::add);
		return books;
	}
	
	public Book getBookById(Long id) {
		return bookRepository.findOne(id);
	}
	
	public void addNewBooks(Book book) {
		bookRepository.save(book);
	}
	
	public void deleteBook(long id) {
		bookRepository.delete(id);
	}
	
	public Book updateBookDetails(Book book) {
		return bookRepository.save(book);
	}
}
