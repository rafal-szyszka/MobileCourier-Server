package pl.s2devs.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.s2devs.order.model.ShippingOrder;

/**
 * Created by rafal on 01.12.17.
 */
@Repository
public interface OrderRepository extends JpaRepository<ShippingOrder, Long> {
    ShippingOrder findByOrderId(Long orderId);
}
