package com.delivery.orderstatus.repo;

import com.delivery.orderstatus.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderStatusRepo extends JpaRepository<OrderStatus, Integer> {
    public OrderStatus findById(int orderId);

}
