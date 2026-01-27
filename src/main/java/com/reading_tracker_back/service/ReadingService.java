package com.reading_tracker_back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reading_tracker_back.domain.Reading;
import com.reading_tracker_back.dto.reading.CreateReadingRequest;
import com.reading_tracker_back.dto.reading.ReadingResponse;
import com.reading_tracker_back.repository.ReadingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadingService {
	
	private final ReadingRepository readingRepository;
	
	public ReadingResponse create(CreateReadingRequest request) {
		Reading created = readingRepository.save(request.toEntity());
		return new ReadingResponse(created);
	}
	
	public List<ReadingResponse> findAll() {
		return readingRepository.findAll()
				.stream()
				.map(reading -> new ReadingResponse(reading))
				.toList();
	}

}
