package com.order_service.OrderService.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order_service.OrderService.entity.BookDto;

@FeignClient(name = "BookService")
public interface BookClient {
    @GetMapping("/books/{bookId}")
    BookDto getBookById(@PathVariable("bookId") Long bookId);
}
