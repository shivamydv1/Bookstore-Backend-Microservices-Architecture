package com.order_service.OrderService.service;

import com.order_service.OrderService.entity.Order;
import com.order_service.OrderService.response.OrderResponse;

public interface OrderService {
    OrderResponse getOrderById(Long orderId);

    Order saveOrder(Order order);
}
