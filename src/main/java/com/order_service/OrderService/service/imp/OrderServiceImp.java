package com.order_service.OrderService.service.imp;

import com.order_service.OrderService.FeignClient.BookClient;
import com.order_service.OrderService.FeignClient.UserClient;
import com.order_service.OrderService.entity.BookDto;
import com.order_service.OrderService.entity.Order;
import com.order_service.OrderService.entity.UserDto;
import com.order_service.OrderService.repository.OrderRepository;
import com.order_service.OrderService.response.OrderResponse;
import com.order_service.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;
    private final BookClient bookClient;
    private final UserClient userClient;


    @Override
    public OrderResponse getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        BookDto book = bookClient.getBookById(order.getBookId());
        UserDto user = userClient.getUserById(order.getUserId());

        return new OrderResponse(order, book, user);
    }


    @Override
    public Order saveOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }


}
