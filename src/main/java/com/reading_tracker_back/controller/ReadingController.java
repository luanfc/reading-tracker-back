package com.reading_tracker_back.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reading_tracker_back.dto.reading.CreateReadingRequest;
import com.reading_tracker_back.dto.reading.ReadingResponse;
import com.reading_tracker_back.service.ReadingService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/readings")
@RequiredArgsConstructor
public class ReadingController {

	private final ReadingService readingService;
	
	@PostMapping
	public ResponseEntity<ReadingResponse> createReading(
			@Valid
			@RequestBody
			CreateReadingRequest request
	) {
		ReadingResponse created = readingService.create(request);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ReadingResponse>> getAllReadings() {
		return ResponseEntity.ok(readingService.findAll());
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<List<ReadingResponse>> getReadingsByBookId(@PathVariable Long id) {
		return ResponseEntity.ok(readingService.findByBookId(id));
	}
}
