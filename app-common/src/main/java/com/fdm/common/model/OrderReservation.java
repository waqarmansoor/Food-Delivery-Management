package com.fdm.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wmansoor on 1/6/2019.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderReservation {

    long OrderId;
    ResturantDetails resturantDetails;
    CustomerDetails customerDetails;
    OrderReservationItems orderReservationItems;

}
