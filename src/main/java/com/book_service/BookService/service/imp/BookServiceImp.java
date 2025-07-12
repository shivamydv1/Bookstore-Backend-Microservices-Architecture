package com.book_service.BookService.service.imp;

import com.book_service.BookService.FeignClient.UserClient;
import com.book_service.BookService.dto.BookDto;
import com.book_service.BookService.dto.UserDto;
import com.book_service.BookService.entity.Book;
import com.book_service.BookService.repository.BookRepository;
import com.book_service.BookService.response.BookResponse;
import com.book_service.BookService.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;
    private final UserClient userClient;

    @Override
    public BookResponse getBookByIdWithUser(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        UserDto userDto = userClient.getUserById(book.getUserId());


        return new  BookResponse(book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                userDto

        );
    }


    private BookDto mapToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .userId(book.getUserId())
                .build();
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .description(bookDto.getDescription())
                .userId(bookDto.getUserId())
                .build();

        Book saved = bookRepository.save(book);
        return mapToDto(saved);
    }

    @Override
    public List<BookDto> getBooksByUserId(Long userId) {
        return bookRepository.findByUserId(userId)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }
    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return mapToDto(book);
    }



    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }




}
