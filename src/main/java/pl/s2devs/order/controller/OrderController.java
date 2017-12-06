package pl.s2devs.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s2devs.order.model.OrderDTO;
import pl.s2devs.order.model.OrderStatus;
import pl.s2devs.order.model.ShippingOrder;
import pl.s2devs.order.service.OrderService;
import pl.s2devs.shared.response.exceptions.OrderNotFoundException;
import pl.s2devs.shared.response.exceptions.PersonNotFoundException;
import pl.s2devs.shared.response.person.UpdateResponse;

import java.util.List;

/**
 * Created by rafal on 01.12.17.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ShippingOrder> placeNewOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.ok(orderService.placeNewOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<ShippingOrder>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @PutMapping(params = {"orderId", "courierId"})
    public ResponseEntity<UpdateResponse<ShippingOrder>> assignCourierToOrder(
            @RequestParam Long orderId,
            @RequestParam Long courierId
    ) {
        try {
            return ResponseEntity.ok(
                    new UpdateResponse<>(
                            orderService.assignCourierToOrder(orderId, courierId),
                            UpdateResponse.UPDATED
                    )
            );
        } catch (OrderNotFoundException | PersonNotFoundException e) {
            return ResponseEntity.ok(
                    new UpdateResponse<>(null, UpdateResponse.FAILED_TO_UPDATE));
        }
    }

    @PutMapping(value = "/status", params = {"orderId", "orderStatus"})
    public ResponseEntity<UpdateResponse<ShippingOrder>> updateOrderStatus(
            @RequestParam Long orderId,
            @RequestParam OrderStatus orderStatus
    ) {
        try {
            return ResponseEntity.ok(
                    new UpdateResponse<>(
                            orderService.updateOrderStatusById(orderId, orderStatus),
                            UpdateResponse.UPDATED
                    )
            );
        } catch (OrderNotFoundException e) {
            return ResponseEntity.ok(
                    new UpdateResponse<>(
                            null,
                            UpdateResponse.FAILED_TO_UPDATE
                    )
            );
        }
    }

}