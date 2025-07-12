package com.book_service.BookService.service;

import com.book_service.BookService.dto.BookDto;
import com.book_service.BookService.response.BookResponse;

import java.util.List;

public interface BookService {
    BookResponse getBookByIdWithUser(Long bookId);

    BookDto createBook(BookDto bookDto);
    List<BookDto> getBooksByUserId(Long userId);
    BookDto getBookById(Long bookId);
    List<BookDto> getAllBooks();
    void deleteBook(Long bookId);
}
