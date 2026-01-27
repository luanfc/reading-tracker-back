package com.reading_tracker_back.dto.reading;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.reading_tracker_back.domain.Reading;

public record ReadingResponse(
		UUID id,
		LocalDate date,
		LocalTime startTime,
		LocalTime endTime,
		int startPage,
		int endPage,
		String notes,
		String bookName
) {
	
	public ReadingResponse(Reading reading) {
		this(reading.getId(),
			reading.getDate(),
			reading.getStartTime(),
			reading.getEndTime(),
			reading.getStartPage(),
			reading.getEndPage(),
			reading.getNotes(),
			reading.getBook().getTitle()
		);
	}

}
