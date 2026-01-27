package com.reading_tracker_back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reading_tracker_back.domain.Book;
import com.reading_tracker_back.dto.book.BookResponse;
import com.reading_tracker_back.dto.book.CreateBookRequest;
import com.reading_tracker_back.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;
	
	public BookResponse create(CreateBookRequest request) {
		Book created = bookRepository.save(request.toEntity());
		return new BookResponse(created);
	}
	
	public List<BookResponse> findAll() {
		return bookRepository.findAll()
				.stream()
				.map(book -> new BookResponse(book))
				.toList();
	}
}
