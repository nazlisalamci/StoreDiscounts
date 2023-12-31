package com.storediscounts.StoreDiscounts.models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;

    

}
