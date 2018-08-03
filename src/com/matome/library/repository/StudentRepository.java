package com.matome.library.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matome.library.model.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
	
  Student findById(long studentId);
  Student findByUserName(String userName);
}
