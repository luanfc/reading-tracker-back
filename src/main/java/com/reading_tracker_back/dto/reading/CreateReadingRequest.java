package com.reading_tracker_back.dto.reading;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

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
		UUID bookId
) {

	public Reading toEntity() {
		return Reading.builder()
				.date(date)
				.startTime(startTime)
				.endTime(endTime)
				.startPage(startPage)
				.endPage(endPage)
				.notes(notes)
				.build();
				
	}
}
