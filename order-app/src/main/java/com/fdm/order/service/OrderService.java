package com.fdm.order.service;

import com.fdm.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wmansoor on 1/6/2019.
 */
@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;
    
    public void orderReceive(Order order){
        
        getCustomerDetails();
        getResturantDetails();
        getRiderDetails();
        orderReservation();
        
    }

    private void orderReservation() {
    }

    private void getRiderDetails() {
    }

    private void getResturantDetails() {
    }

    private void getCustomerDetails() {

    }
}
