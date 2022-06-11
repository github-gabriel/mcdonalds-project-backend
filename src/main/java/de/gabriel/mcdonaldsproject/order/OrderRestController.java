package de.gabriel.mcdonaldsproject.order;

import de.gabriel.mcdonaldsproject.extraItem.ExtraItem;
import de.gabriel.mcdonaldsproject.extraItem.ExtraItemRepository;
import de.gabriel.mcdonaldsproject.subItem.SubItem;
import de.gabriel.mcdonaldsproject.subItem.SubItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SubItemRepository subItemRepository;

    @Autowired
    ExtraItemRepository extraItemRepository;

    @GetMapping
    List<Order> getOrders(){return orderRepository.findAll();}

    @PostMapping
    Order createOrder(@RequestBody Order order){return orderRepository.save(order);}

    @PutMapping("/{orderId}/subItems/{subItemId}/extraItems/{extraItemId}")
    Order subItemsToOrder(
            @PathVariable Long orderId,
            @PathVariable Long subItemId,
            @PathVariable Long extraItemId
    ){
        Order order = orderRepository.findById(orderId).get();
        SubItem subItem = subItemRepository.findById(subItemId).get();
        ExtraItem extraItem = extraItemRepository.findById(extraItemId).get();
        subItem.extraItem(extraItem);
        order.subItem(subItem);
        return orderRepository.save(order);
    }

}
