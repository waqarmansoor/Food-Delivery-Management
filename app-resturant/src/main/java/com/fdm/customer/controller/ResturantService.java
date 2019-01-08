package com.fdm.customer.controller;


import com.fdm.common.model.Customer;
import com.fdm.common.model.ResturantDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmansoor on 1/6/2019.
 */

@RestController
@RequestMapping("resturant")
public class ResturantService {

    @GetMapping("/details/{hotel-name}/{delivery-address}")
    public ResturantDetails post(@PathVariable("hotel-name") final String hotelName,@PathVariable("delivery-address") final String deliveryAddress) {
        ResturantDetails resturantDetails = ResturantDetails.builder().resturantName(hotelName).resturantContact("111-111-107").resturantAddress("Tipu Sultan Road").build();
        return resturantDetails;
    }

}
