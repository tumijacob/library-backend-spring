package com.matome.library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.library.model.Librarian;
import com.matome.library.repository.LibrarianRepository;

@Service
public class LibrarianService {
	
	@Autowired
	private LibrarianRepository librarianRepository;
	
	public List<Librarian> getAllLibrarians() {
		List<Librarian> librarians = new ArrayList<>();
		librarianRepository.findAll()
		    .forEach(librarians::add);
		return librarians;
	}
	
	public Librarian getLibrarianById(Long id) {
		return librarianRepository.findOne(id);
	}
	
	public void createLibrarian(Librarian librarian) {
		librarianRepository.save(librarian);
	}
	
	public Librarian updateLibrarian(Long id, Librarian librarian) {
		return librarianRepository.save(librarian);
	}
	
	public void deleteLibraraian(long id) {
		librarianRepository.delete(id);
	}
}
