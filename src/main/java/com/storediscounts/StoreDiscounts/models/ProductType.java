package com.storediscounts.StoreDiscounts.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class ProductType {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "productType")
    private List<Product> items;

}
