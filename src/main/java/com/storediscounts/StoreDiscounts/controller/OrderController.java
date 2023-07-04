package com.storediscounts.StoreDiscounts.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.storediscounts.StoreDiscounts.models.Card;
import com.storediscounts.StoreDiscounts.models.Customer;
import com.storediscounts.StoreDiscounts.models.Product;
import com.storediscounts.StoreDiscounts.models.ProductType;
import com.storediscounts.StoreDiscounts.repository.CardRepository;
import com.storediscounts.StoreDiscounts.repository.CustomerRepository;
import com.storediscounts.StoreDiscounts.repository.ProductRepository;
import com.storediscounts.StoreDiscounts.repository.ProductTypeRepository;
import com.storediscounts.StoreDiscounts.services.OrderServices;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderServices _orderServices;

  @PostMapping("/api/2.0/order")
public ResponseEntity<?>  postOrder(@RequestBody Map<String, Object> requestParams) throws Exception {



    List<Integer> product_id = new ArrayList<>();

    Integer customerId = (Integer) requestParams.get("CustomerId");
    List<Integer> products = (List<Integer>) requestParams.get("Products");
    
     if(customerId==null || products==null  || products.size()==0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    for (Integer productId : products) {
        product_id.add(productId);
    }

    _orderServices.GetOrder(customerId, product_id);

    return ResponseEntity.status(200).build();

    
}


}
