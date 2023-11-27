package com.delivery.checkoutservice.controller;

import com.delivery.checkoutservice.domain.CheckoutItem;
import com.delivery.checkoutservice.repo.CheckoutRepository;
import com.delivery.checkoutservice.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckoutController {
    private CheckoutService checkoutService;
    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }

    @PostMapping("/placeorder")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<CheckoutItem>> placeOrder(@RequestBody List<CheckoutItem> checkoutItemList){

        return new ResponseEntity(checkoutService.saveOrder(checkoutItemList), HttpStatus.CREATED);
    }

    @GetMapping("/orderdetails/{checkUserId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<CheckoutItem> getAllOrders(@PathVariable String checkUserId) {
        List<CheckoutItem> checkObj=null;
        checkObj=checkoutService.fetchAllByUserId(checkUserId);
        return (List<CheckoutItem>) checkObj;
    }

}
