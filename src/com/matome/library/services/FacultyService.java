package com.matome.library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matome.library.model.Faculty;
import com.matome.library.repository.FacultyRepository;

@Service
public class FacultyService {
	@Autowired
	private FacultyRepository facultyRepository;
	
	public List<Faculty> getAllFaculties() {
		List<Faculty> faculties = new ArrayList<>();
		facultyRepository.findAll()
		    .forEach(faculties::add);
		return faculties;
	}
	
	public Faculty getFacultyById(Long id) {
		return facultyRepository.findOne(id);
	}
	
	public void addFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
	}
	
	public Faculty updateFaculty(Long id, Faculty faculty) {
		return facultyRepository.save(faculty);
	}

}
