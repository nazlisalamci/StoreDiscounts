package com.storediscounts.StoreDiscounts.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Card {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int discount;

    @OneToMany(mappedBy = "card")
    private List<Customer> card;

}
