package com.storediscounts.StoreDiscounts.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
public void postOrder(@RequestBody Map<String, Object> requestParams) throws Exception {
    List<Integer> product_id = new ArrayList<>();

    Integer customerId = (Integer) requestParams.get("CustomerId");
    List<Integer> products = (List<Integer>) requestParams.get("Products");

    for (Integer productId : products) {
        product_id.add(productId);
    }

    _orderServices.GetOrder(customerId, product_id);

    
}

    @Autowired
    ProductRepository _productRepository;

    @Autowired
    CardRepository _cardRepository;

    @GetMapping("/api/2.0/save-card")
    public void saveCard() throws Exception {
        Card card = new Card();
        card.setName("silver");
        card.setDiscount(20);
        _cardRepository.save(card);

        Card card2 = new Card();
        card2.setName("gold");
        card2.setDiscount(30);
        _cardRepository.save(card2);

        Card card3 = new Card();
        card3.setName("notHave");
        card3.setDiscount(0);
        _cardRepository.save(card3);

    }

    @Autowired
    CustomerRepository _customerRepository;

    @GetMapping("/api/2.0/save-customer")
    public void saveCustomer() throws Exception {

        Customer customer = new Customer();
        LocalDate date = LocalDate.now();
        customer.setAddress("Turkey");
        customer.setCreationDate(date);
        customer.setEmail("a@a.com");
        customer.setName("naz");
        customer.setSurname("salamci");
        customer.setPassword("123");
        customer.setAffiliate(true);
        customer.setCard(_cardRepository.findCard(1));
        _customerRepository.save(customer);

    }

    @Autowired
    ProductTypeRepository _productTypeRepository;

    @GetMapping("/api/2.0/save-product-type")
    public void saveProductType() throws Exception {

        ProductType productType = new ProductType();
        productType.setName("Telefon");
        _productTypeRepository.save(productType);

        ProductType productType2 = new ProductType();
        productType2.setName("PC");
        _productTypeRepository.save(productType2);

    }

    @GetMapping("/api/2.0/save-product")
    public void saveProduct() throws Exception {

        /*
         * Product product2 = new Product();
         * product2.setName("iphone");
         * product2.setPrice(20000);
         * product2.setProductType(_productTypeRepository.findProductType(1));
         * _productRepository.save(product2);
         */

        Product product3 = new Product();
        product3.setName("Monstar");
        product3.setPrice(32000);
        product3.setProductType(_productTypeRepository.findProductType(2));
        _productRepository.save(product3);

    }

}
