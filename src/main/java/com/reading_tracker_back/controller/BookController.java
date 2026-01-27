package com.reading_tracker_back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reading_tracker_back.dto.book.BookResponse;
import com.reading_tracker_back.dto.book.CreateBookRequest;
import com.reading_tracker_back.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
	
	private final BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookResponse> createBook(
			@Valid
			@RequestBody
			CreateBookRequest request
	){
		BookResponse created = bookService.create(request);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<BookResponse>> getAllBooks() {
		return ResponseEntity.ok(bookService.findAll());
	}

}
