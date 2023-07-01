package com.storediscounts.StoreDiscounts.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.storediscounts.StoreDiscounts.services.OrderServices;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderServices _orderServices;

    @GetMapping("/api/2.0/order")
    public void postPalaces() throws Exception {
        List<Integer> product_id = new ArrayList<Integer>();
        
        product_id.add(2);
        product_id.add(1);

        _orderServices.GetOrder(1, product_id);
    }

}
