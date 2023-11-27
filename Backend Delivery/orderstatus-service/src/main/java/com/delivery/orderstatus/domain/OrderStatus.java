package com.delivery.orderstatus.domain;

import com.delivery.checkoutservice.domain.CheckoutItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="order_status")
@Data
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int totalAmount;
    private String ordStatus;

}
