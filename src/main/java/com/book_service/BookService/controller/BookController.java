package com.book_service.BookService.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.book_service.BookService.dto.BookDto;
import com.book_service.BookService.service.imp.BookServiceImp;

import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImp bookServiceImp;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookServiceImp.createBook(bookDto));
    }

     @GetMapping("/user/{userId}")
     public ResponseEntity<List<BookDto>> getBooksByUserId(@PathVariable Long userId) {
         return ResponseEntity.ok(bookServiceImp.getBooksByUserId(userId));
     }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookServiceImp.getBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookServiceImp.getAllBooks());
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServiceImp.deleteBook(id);
    }
    
    
     
}
