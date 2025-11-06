package com.service.order.order.service.service.serviceImpl;

import com.service.order.order.service.entity.Order;
import com.service.order.order.service.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public boolean deleteOrder(Long id) {
        return false;
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public Order getOrderByProductId(Long id) {
        return null;
    }

    @Override
    public List<Order> getAllOrderFromUserId(Long id) {
        return List.of();
    }
}
