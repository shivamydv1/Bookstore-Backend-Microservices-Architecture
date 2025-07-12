package com.order_service.OrderService.response;

import com.order_service.OrderService.entity.BookDto;
import com.order_service.OrderService.entity.Order;
import com.order_service.OrderService.entity.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Order order;
    private BookDto book;
    private UserDto user;
}
