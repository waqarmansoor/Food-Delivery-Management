package com.fdm.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wmansoor on 1/6/2019.
 */
@Data
@NoArgsConstructor
public class OrderItems {

    String hotelName;
    String itemName;
    int quantity;
}
