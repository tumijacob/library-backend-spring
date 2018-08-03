package com.matome.library.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matome.library.model.Librarian;

@Repository
@Transactional
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Librarian findByLibrarianName(String librarianName);
}
