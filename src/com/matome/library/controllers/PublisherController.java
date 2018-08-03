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

import com.matome.library.model.Publisher;
import com.matome.library.services.PublisherService;

@RestController
@RequestMapping("publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping("/publishers")
	public List<Publisher> findAllPublishers() {
		return publisherService.getAllPublishers();
	}
	
	@PostMapping("/add")
	public void savePublisher(@RequestBody Publisher publisher) {
		publisherService.addPublisher(publisher);
	}
	
	@PutMapping("/modify-pub")
	public void modifyPub(@RequestBody Publisher publisher, @RequestParam("id") long id) {
		publisherService.updatePublisher(id, publisher);
	}
	
	

}
