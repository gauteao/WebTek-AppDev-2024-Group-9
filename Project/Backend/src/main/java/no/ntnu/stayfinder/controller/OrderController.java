package no.ntnu.stayfinder.controller;

import no.ntnu.stayfinder.model.Order;
import no.ntnu.stayfinder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin(origins = "http://localhost:63342")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {

        return orderService.getOrders();
    }

    @GetMapping(path = "{orderId}")
    public Order getOrderById(@PathVariable("orderId") Long id) {

        return orderService.getOrder(id);
    }

    @PostMapping
    public void registerNewOrder(@RequestBody Order order) {

        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long id) {

        orderService.deleteOrder(id);
    }
}
