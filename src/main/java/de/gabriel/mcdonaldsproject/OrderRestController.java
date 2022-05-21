package de.gabriel.mcdonaldsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/manager")
    public String manager() {
        return "Manager Page";
    }

    @GetMapping("/employee")
    public String employee() {
        return "Employee Page";
    }

    @GetMapping("/")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping("/new_order")
    public void registerNewOrder(@RequestBody Order order) {
        System.out.println("New Order!");
        orderService.addNewOrder(order);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping(path = "edit/{id}")
    public void updateOrder(
            @PathVariable("id") Long id,
            @RequestBody(required = false) String product) {
        System.out.println("Edited existing order with id " + id + " product " + product);
        orderService.updateOrder(id,product);
    }

}
