package com.storediscounts.StoreDiscounts.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Card {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int discount;

}
