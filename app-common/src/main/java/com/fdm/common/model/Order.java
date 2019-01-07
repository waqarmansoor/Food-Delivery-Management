package com.fdm.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by wmansoor on 1/6/2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    long orderId;
    long customerId;
    String address;
    List<OrderItems> orderItems;

    public Order(long orderId){
        this.orderId = orderId;
    }

}
