package com.orderservice.order_service.service;

import com.orderservice.order_service.entity.Order;
import com.orderservice.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        // Implement order processing logic

        return orderRepository.save(order);
    }

    public Order getOrder(Long orderId) {
        // Implement logic to retrieve an order by its ID
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    public List<Order> getAllOrders() {
        // Implement logic to retrieve all orders
        return orderRepository.findAll();
    }

    public Order updateOrder(Long orderId, Order order) {
        // Implement logic to update an existing order
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order existingOrder = optionalOrder.get();
            // Update order properties with the new values
            existingOrder.setOrderDetails(order.getOrderDetails());
            // Save the updated order
            return orderRepository.save(existingOrder);
        } else {
            return null;
        }
    }

    public boolean deleteOrder(Long orderId) {
        // Implement logic to delete an order by its ID
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        } else {
            return false;
        }
    }

}
