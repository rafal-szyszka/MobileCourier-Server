package pl.s2devs.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.order.model.OrderStatus;
import pl.s2devs.order.model.ShippingOrder;
import pl.s2devs.order.model.OrderDTO;
import pl.s2devs.order.repository.OrderRepository;
import pl.s2devs.person.model.Courier;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.repository.CourierRepository;
import pl.s2devs.person.repository.PersonRepository;
import pl.s2devs.shared.response.exceptions.OrderNotFoundException;
import pl.s2devs.shared.response.exceptions.PersonNotFoundException;

import java.util.List;

/**
 * Created by rafal on 01.12.17.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CourierRepository courierRepository;

    public ShippingOrder placeNewOrder(OrderDTO order) {
        ShippingOrder placedShippingOrder = new ShippingOrder(order);
        assignPersonsToOrder(placedShippingOrder, order);
        saveOrderInDataBase(placedShippingOrder);

        return placedShippingOrder;
    }

    private void saveOrderInDataBase(ShippingOrder placedShippingOrder) {
        orderRepository.save(placedShippingOrder);
    }

    private void assignPersonsToOrder(ShippingOrder placedShippingOrder, OrderDTO order) {
        Person recipient = personRepository.findByPersonId(order.getRecipientId());
        Person sender = personRepository.findByPersonId(order.getSenderId());

        placedShippingOrder.getOrderDetails().setRecipient(recipient);
        placedShippingOrder.getOrderDetails().setSender(sender);
    }

    public List<ShippingOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public ShippingOrder assignCourierToOrder(Long orderId, Long courierId) throws OrderNotFoundException, PersonNotFoundException {
        Courier courier = courierRepository.findByCourierId(courierId);
        ShippingOrder order = orderRepository.findByOrderId(orderId);

        handleNullPointers(courier, order);
        updateOrder(order, courier);

        return order;
    }

    public ShippingOrder updateOrderStatusById(Long orderId, OrderStatus orderStatus) throws OrderNotFoundException {
        ShippingOrder order = orderRepository.findByOrderId(orderId);

        updateStatus(order, orderStatus);

        return order;
    }

    private void updateStatus(ShippingOrder order, OrderStatus orderStatus) throws OrderNotFoundException {
        if(order != null) {
            order.setStatus(orderStatus);
            orderRepository.save(order);
        } else {
            throw new OrderNotFoundException("No order found.");
        }
    }

    private void updateOrder(ShippingOrder order, Courier courier) {
        order.setAssignedCourier(courier);
        orderRepository.save(order);
    }

    private void handleNullPointers(Courier courier, ShippingOrder order) throws PersonNotFoundException, OrderNotFoundException {
        if(courier == null) throw new PersonNotFoundException("Kurier o podanym id nie został znaleziony");
        if(order == null) throw new OrderNotFoundException("Zamówienie o podanym id nie istnieje");
    }
}
