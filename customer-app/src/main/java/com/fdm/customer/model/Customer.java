package com.fdm.customer.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by wmansoor on 1/6/2019.
 */
@Data
@Builder
public class Customer {

    long id;
    String name;
    String contactNo;
}
