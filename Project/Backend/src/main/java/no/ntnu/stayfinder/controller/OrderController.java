package no.ntnu.stayfinder.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.ntnu.stayfinder.model.Order;
import no.ntnu.stayfinder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
    * REST API controller serving endpoints for orders.
 */

@RestController
@RequestMapping(path = "/api/orders")
@CrossOrigin(origins = "http://localhost:63342")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping
    @Operation
            (summary = "Get all orders",
                    description = "Returns a list of all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The orders returned in the response body"),
            @ApiResponse(responseCode = "404", description = "No orders found")
    })

    public List<Order> getOrders() {

        return orderService.getOrders();
    }

    @GetMapping(path = "{orderId}")
    @Operation
            (summary = "Get an order by ID",
                    description = "Returns an order with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The order returned in the response body"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })

    public Order getOrderById(@PathVariable("orderId") Long id) {

        return orderService.getOrder(id);
    }

    @PostMapping
    @Operation
            (summary = "Register a new order",
                    description = "Registers a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The order has been registered"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })

    public void registerNewOrder(@RequestBody Order order) {

        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    @Operation
            (summary = "Delete an order",
                    description = "Deletes an order with the specified ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The order has been deleted"),
            @ApiResponse(responseCode = "404", description = "Order not found")
    })
    public void deleteOrder(@PathVariable("orderId") Long id) {

        orderService.deleteOrder(id);
    }
}
