package com.storediscounts.StoreDiscounts.models;


import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate date;

    private double invoice;

   @ManyToOne
    private Customer customer;

    
    @OneToMany(mappedBy = "ordersProduct")
    private List<OrdersProduct> items;


}
