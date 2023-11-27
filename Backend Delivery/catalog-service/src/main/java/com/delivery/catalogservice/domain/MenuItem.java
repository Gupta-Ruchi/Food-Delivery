package com.delivery.catalogservice.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="menu_item")
@Data
public class MenuItem {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int Id;

    private String itemName;
    private String itemDescription;
    private String itemPrice;

}
