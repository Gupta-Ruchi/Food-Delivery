package com.delivery.orderstatus.service;

import com.delivery.checkoutservice.domain.CheckoutItem;
import com.delivery.orderstatus.domain.OrderStatus;
import com.delivery.orderstatus.repo.orderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderStatusService {
    private orderStatusRepo orderstatusrepo;

    @Autowired
    public orderStatusService(orderStatusRepo orderstatusrepo){this.orderstatusrepo=orderstatusrepo;}

    public OrderStatus saveOrder(OrderStatus orderStatus) {
        return orderstatusrepo.save(orderStatus);
    }

}
