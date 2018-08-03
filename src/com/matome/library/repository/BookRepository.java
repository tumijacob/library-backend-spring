package com.matome.library.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matome.library.model.Book;

@Repository
@Transactional

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByBookName(String bookName);

}
