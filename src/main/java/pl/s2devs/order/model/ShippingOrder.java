package pl.s2devs.order.model;

import pl.s2devs.person.model.Courier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by rafal on 01.12.17.
 */
@Entity
public class ShippingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @NotNull
    private String pickupCode;

    @NotNull
    private String cost;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courier_id")
    private Courier assignedCourier;

    public ShippingOrder() {
    }

    public ShippingOrder(OrderDTO orderDTO) {
        this.status = orderDTO.getStatus();
        this.pickupCode = orderDTO.getPickupCode();
        this.cost = orderDTO.getCost();

        this.orderDetails = new OrderDetails(
                orderDTO.getItems(),
                orderDTO.getDescription()
        );
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getPickupCode() {
        return pickupCode;
    }

    public void setPickupCode(String pickupCode) {
        this.pickupCode = pickupCode;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Courier getAssignedCourier() {
        return assignedCourier;
    }

    public void setAssignedCourier(Courier assignedCourier) {
        this.assignedCourier = assignedCourier;
    }
}
