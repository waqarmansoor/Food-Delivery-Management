package com.fdm.order.controller;

import com.fdm.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.Scope;
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

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    ApplicationContext applicationContext ;

    private static final String TOPIC = "order.receive";


    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        Order order = (Order) applicationContext.getBean("bean1");
        Order order2 = (Order) applicationContext.getBean("bean1");

        System.out.println(order== order2);

//        kafkaTemplate.send(TOPIC, new Order(1L));

        return "Published successfully";
    }


}
