package com.matome.library.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matome.library.model.Faculty;

@Repository
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	
	  Faculty findById(Long id);
}
