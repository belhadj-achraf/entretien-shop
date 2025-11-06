package com.service.order.order.service.service;

import com.service.order.order.service.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public Order createOrder(Order order);
    public boolean deleteOrder(Long id);
    public Order updateOrder(Long id, Order order);
    public List<Order> getAllOrders();
    public Order getOrderByProductId(Long id);
    public List<Order> getAllOrderFromUserId(Long id);

}
