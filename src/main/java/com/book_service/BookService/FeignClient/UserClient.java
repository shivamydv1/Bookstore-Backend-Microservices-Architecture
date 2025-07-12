package com.book_service.BookService.FeignClient;

import com.book_service.BookService.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserService")
public interface UserClient {

    @GetMapping("/user/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);
}
