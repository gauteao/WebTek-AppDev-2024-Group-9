package no.ntnu.stayfinder.service;

import no.ntnu.stayfinder.model.Order;
import no.ntnu.stayfinder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if (!exists) {
            throw new IllegalStateException("order with id " + orderId + " does not exist");
        }
        orderRepository.deleteById(orderId);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("order with id " + id + " does not exist"));
    }
}
