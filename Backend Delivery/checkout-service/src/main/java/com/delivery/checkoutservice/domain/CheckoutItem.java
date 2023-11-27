package com.delivery.checkoutservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order_details")
@Data
public class CheckoutItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemNames;
    private String itemDescriptions;
    private String itemPrices;
    private int itemQuantity;
    private String emailIds;
    private String address;
    private String contact;
    private String orderStatus;
    private String checkUserId;

    /*
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<OrderManagement> orderManagement;*/
}
