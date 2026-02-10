package com.reading_tracker_back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reading_tracker_back.domain.Book;
import com.reading_tracker_back.domain.Reading;
import com.reading_tracker_back.dto.reading.CreateReadingRequest;
import com.reading_tracker_back.dto.reading.ReadingResponse;
import com.reading_tracker_back.repository.BookRepository;
import com.reading_tracker_back.repository.ReadingRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadingService {
	
	private final ReadingRepository readingRepository;
	private final BookRepository bookRepository;
	
	public ReadingResponse create(CreateReadingRequest request) {
		Book book = bookRepository.findById(request.bookId())
				.orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
		
		Reading reading = request.toEntity(book);
		
		return new ReadingResponse(readingRepository.save(reading));
	}
	
	public List<ReadingResponse> findAll() {
		return readingRepository.findAll()
				.stream()
				.map(reading -> new ReadingResponse(reading))
				.toList();
	}

	public List<ReadingResponse> findByBookId(Long id) {
		return readingRepository.findById(id)
				.stream()
				.map(reading -> new ReadingResponse(reading))
				.toList();
	}

}
