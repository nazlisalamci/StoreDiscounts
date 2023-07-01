package com.storediscounts.StoreDiscounts.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storediscounts.StoreDiscounts.models.Card;
import com.storediscounts.StoreDiscounts.models.Customer;
import com.storediscounts.StoreDiscounts.models.Orders;
import com.storediscounts.StoreDiscounts.models.Product;
import com.storediscounts.StoreDiscounts.repository.CustomerRepository;
import com.storediscounts.StoreDiscounts.repository.OrderRepository;
import com.storediscounts.StoreDiscounts.repository.ProductRepository;

@Service
public class OrderServices {

    @Autowired
    OrderRepository _orderRepository;

    @Autowired
    CustomerRepository _customerRepository;

    @Autowired
    ProductRepository _productRepository;


    public double CalculateInvoce(Customer customer, Card card, double invoice) {
        double discount = 0;

        if (card != null || card.getId() != 0) {
            discount = card.getDiscount();
        } else if (customer.getAffiliate()) {
            discount = 10;
        } else if (customer.getCreationDate().isBefore(LocalDate.now().minusYears(2))) {
            discount = 5;
        }
        invoice -= (invoice / 100) * discount;

        return invoice;

    }

    public void GetOrder(int CustomerId, List<Integer> products_id) {

        Customer customer = _customerRepository.findCustomer(CustomerId);
        Orders order = new Orders();
        Card card = customer.getCard();

        LocalDate date = LocalDate.now();
        order.setDate(date);
        order.setCustomer(customer);
        Product product = new Product();

        double orderInvoce = 0;

        for (int p : products_id) {

            product = _productRepository.findProduct(p);
            System.out.println(product);

            if (product.getProductType().getId() != 1) {
                orderInvoce += CalculateInvoce(customer, card, product.getPrice());
            }
            else{
                 orderInvoce +=product.getPrice();
            }
        }

        orderInvoce -=  ((int)(orderInvoce / 200)*5);

        System.out.println(orderInvoce);
        order.setInvoice(orderInvoce);
        System.out.println(order);

        _orderRepository.save(order);

    }
}
