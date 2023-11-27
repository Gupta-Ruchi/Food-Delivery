package com.delivery.checkoutservice.repo;

import com.delivery.checkoutservice.domain.CheckoutItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<CheckoutItem, Integer> {

    @Query(value="select * from order_details ord where ord.check_user_id=?",nativeQuery = true)
    List<CheckoutItem> findAllByUserId(String checkUserId);
}
