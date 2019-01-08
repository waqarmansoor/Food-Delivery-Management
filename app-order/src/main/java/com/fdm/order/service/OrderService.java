package com.fdm.order.service;

import com.fdm.common.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wmansoor on 1/6/2019.
 */
@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private KafkaTemplate<String, OrderReservation> kafkaTemplate;
    
    public void orderReceive(Order order){
        List<OrderReservation> orderReservations = new ArrayList<>();
        Customer customer = getCustomerDetails(order);
        CustomerDetails customerDetails = CustomerDetails.builder()
                .customerId(customer.getId())
                .customerName(customer.getName())
                .customerContact(customer.getContactNo())
                .customerDeliveryAddress(order.getAddress())
                .build();

        for(OrderItems orderItems : order.getOrderItems()){
            ResturantDetails resturantDetails = getResturantDetails(orderItems.getHotelName(),order.getAddress());
            OrderReservation orderReservation = OrderReservation.builder()
                    .OrderId(order.getOrderId())
                    .customerDetails(customerDetails)
                    .resturantDetails(resturantDetails)
                    .orderReservationItems(new OrderReservationItems(orderItems.getItemName(),orderItems.getQuantity()))
                    .build();
            orderReservations.add(orderReservation);
        }
        orderReservation(orderReservations);
        
    }

    private void orderReservation(List<OrderReservation> orderReservations) {
        orderReservations.forEach(or->{
            kafkaTemplate.send("order.reservation", or);
        });
    }

    private void getRiderDetails() {
    }

    private ResturantDetails getResturantDetails(String hotelName , String deliveryAddress) {
        ResturantDetails resturantDetails = restTemplate.getForObject("http://localhost:8083/resturant/details/"+hotelName+"/"+deliveryAddress,ResturantDetails.class);
        return resturantDetails;
    }

    private Customer getCustomerDetails(Order order) {
       return restTemplate.getForObject("http://localhost:8082/customer/details/"+order.getCustomerId(),Customer.class);
    }
}
