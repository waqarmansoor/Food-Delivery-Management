package com.fdm.order.controller;

import com.fdm.common.model.Order;
import com.fdm.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by wmansoor on 1/6/2019.
 */

@RestController
@RequestMapping("order-service")
public class OrderServiceController {

//    @Autowired
//    private KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    OrderService orderService;

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        orderService.orderReceive(new Order());
//        kafkaTemplate.send(TOPIC, new Order(1L));

        return "Published successfully";
    }


}
