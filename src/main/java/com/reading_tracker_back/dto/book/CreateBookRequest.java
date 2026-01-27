package com.reading_tracker_back.dto.book;

import com.reading_tracker_back.domain.Book;
import com.reading_tracker_back.domain.BookType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBookRequest(

	@NotBlank
	String title,
	
	@NotBlank
	String author,
	
	@Min(1)
	int pages,
	
	@NotNull
	BookType type
) {
	
	public Book toEntity() {
		return Book.builder()
				.title(title)
				.author(author)
				.pages(pages)
				.type(type)
				.build();
	}

}
