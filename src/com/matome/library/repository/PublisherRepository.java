package com.matome.library.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matome.library.model.Publisher;

@Repository
@Transactional
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByPublicationName(String publicationName);
}
