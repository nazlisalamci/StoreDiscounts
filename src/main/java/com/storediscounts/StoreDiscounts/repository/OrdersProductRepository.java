package com.storediscounts.StoreDiscounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storediscounts.StoreDiscounts.models.OrdersProduct;

@Repository
public interface OrdersProductRepository extends JpaRepository<OrdersProduct,Long>{
    
}
