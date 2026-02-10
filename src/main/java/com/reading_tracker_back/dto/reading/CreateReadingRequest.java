package com.reading_tracker_back.dto.reading;

import java.time.LocalDate;
import java.time.LocalTime;

import com.reading_tracker_back.domain.Book;
import com.reading_tracker_back.domain.Reading;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateReadingRequest(
		
		@NotNull
		LocalDate date,
		
		@NotNull
		LocalTime startTime,
		
		@NotNull
		LocalTime endTime,
		
		@Min(1)
		int startPage,
		
		@Min(1)
		int endPage,
		
		String notes,
		
		@NotNull
		Long bookId
) {

	public Reading toEntity(Book book) {
		return Reading.builder()
				.book(book)
				.date(date)
				.startTime(startTime)
				.endTime(endTime)
				.startPage(startPage)
				.endPage(endPage)
				.notes(notes)
				.build();
				
	}
}
