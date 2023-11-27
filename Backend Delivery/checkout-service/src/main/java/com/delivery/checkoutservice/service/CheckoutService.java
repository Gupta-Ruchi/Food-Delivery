package com.delivery.checkoutservice.service;

import com.delivery.checkoutservice.domain.CheckoutItem;
import com.delivery.checkoutservice.repo.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.UUID;

@Service
public class CheckoutService {

    private CheckoutRepository checkoutRepository;
    @Autowired
    public CheckoutService(CheckoutRepository checkoutRepository){
        this.checkoutRepository=checkoutRepository;
    }

    /*public void placeOrder(CheckoutItem checkoutItem){
        CheckoutItem order= new CheckoutItem();
        order.setOrderNumber(UUID.randomUUID().toString());
        checkoutRepository.save(order);
    }*/

    public List<CheckoutItem> saveOrder(List<CheckoutItem> checkoutItemList) {
        return checkoutRepository.saveAll(checkoutItemList);
    }

    public List<CheckoutItem> fetchAllByUserId(String checkUserId) {
        return checkoutRepository.findAllByUserId(checkUserId);
    }
}
