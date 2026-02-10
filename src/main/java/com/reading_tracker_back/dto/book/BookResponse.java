package com.reading_tracker_back.dto.book;

import com.reading_tracker_back.domain.Book;
import com.reading_tracker_back.domain.BookType;

public record BookResponse(
		Long id,
		String title,
		String author,
		int pages,
		BookType type
) {

	public BookResponse(Book book) {
		this(
			book.getId(),
			book.getTitle(),
			book.getAuthor(),
			book.getPages(),
			book.getType()
		);
	}

}
