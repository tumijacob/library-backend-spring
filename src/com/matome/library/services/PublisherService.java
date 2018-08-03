package com.matome.library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.library.model.Book;
import com.matome.library.model.Publisher;
import com.matome.library.repository.PublisherRepository;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private BookService bookService;
	
	public List<Publisher> getAllPublishers() {
		List<Publisher> publications = new ArrayList<>();
		publisherRepository.findAll()
		    .forEach(publications::add);
		return publications;
	}
	
	public Publisher getPublisherById(Long id) {
		return publisherRepository.findOne(id);
	}
	
	public void addPublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}
	
	public Publisher updatePublisher(Long id, Publisher publisher) {
		return publisherRepository.save(publisher);
	}
	
	public void deletePublisher(long id) {
		publisherRepository.delete(id);
	}
	
	public String orderStatus(long id) {
		Book book = bookService.getBookById(id); 
		return book.getStatus();
	}

}
