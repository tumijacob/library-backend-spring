package com.matome.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matome.library.model.Student;

public interface UserRepository extends JpaRepository<Student, Long> {
	Student findByUserName(String userName);

}
