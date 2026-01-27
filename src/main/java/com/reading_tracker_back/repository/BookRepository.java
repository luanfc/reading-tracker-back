package com.reading_tracker_back.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reading_tracker_back.domain.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
