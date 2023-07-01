package com.storediscounts.StoreDiscounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.storediscounts.StoreDiscounts.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
         @Query(value = "SELECT Top(1) * FROM PRODUCT u WHERE u.id = ?1 ",
    nativeQuery = true)
    Product findProduct(int id);
}
