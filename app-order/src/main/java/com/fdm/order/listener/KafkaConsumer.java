package com.fdm.order.listener;

import com.fdm.common.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "ordertopic")
    public void consume(String message) {
        System.out.println("  Consumed message: " + message);
    }


    @KafkaListener(topics = "order", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Order order) {
        System.out.println("Consumed JSON Message: " + order);
    }
}
