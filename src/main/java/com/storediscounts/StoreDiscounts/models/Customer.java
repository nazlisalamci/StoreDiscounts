package com.storediscounts.StoreDiscounts.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String surname;

    private String address;

    private String email;

    private String password;

    private LocalDate creationDate;

    private Boolean affiliate ;

    @OneToOne
    @JoinColumn(name="card_id")
    private Card card;

    

}
