package com.delivery.orderstatus.controller;

import com.delivery.catalogservice.domain.MenuItem;
import com.delivery.checkoutservice.domain.CheckoutItem;
import com.delivery.orderstatus.domain.OrderStatus;
import com.delivery.orderstatus.repo.orderStatusRepo;
import com.delivery.orderstatus.service.orderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class orderStatusController {
    @Autowired
    private orderStatusRepo orderstatusrepo;

    @Autowired
    private orderStatusService orderstatusservice;

    @Autowired
    public orderStatusController(orderStatusService orderstatusservice){this.orderstatusservice=orderstatusservice;}

    @PutMapping("/myorders")
    @CrossOrigin(origins = "http://localhost:4200")
    public OrderStatus update(@RequestBody OrderStatus orderStatus, @PathVariable("orderId") int orderId){
        OrderStatus statusObj=null;
        statusObj=orderstatusrepo.findById(orderId);
        statusObj.setOrdStatus(orderStatus.getOrdStatus());
        statusObj=orderstatusservice.saveOrder(orderStatus);
        return statusObj;
    }

}
