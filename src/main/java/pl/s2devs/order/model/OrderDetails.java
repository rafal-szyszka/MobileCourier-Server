package pl.s2devs.order.model;

import pl.s2devs.person.model.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by rafal on 01.12.17.
 */
@Entity
public class OrderDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailsId;

    @ElementCollection(targetClass = String.class)
    private List<String> items;

    @NotNull
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "recipient_id")
    private Person recipient;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    @JoinColumn(name = "sender_id")
    private Person sender;

    public OrderDetails() {
    }

    public OrderDetails(List<String> items, String description) {
        this.items = items;
        this.description = description;
    }

    public Long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getRecipient() {
        return recipient;
    }

    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

}
