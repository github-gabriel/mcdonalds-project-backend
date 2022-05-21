package de.gabriel.mcdonaldsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        boolean exists = orderRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Order with the ID " + id + " does not exist");
        }
        orderRepository.deleteById(id);
    }

    @Transactional
    public void updateOrder(Long id, String product) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("Order with ID " + id + " does not exist!"));
        if (product != null && product.length() > 0) {
            order.setProduct(product);
        }
    }
}
