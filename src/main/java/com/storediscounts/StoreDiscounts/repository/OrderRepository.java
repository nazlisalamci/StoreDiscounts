package com.storediscounts.StoreDiscounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storediscounts.StoreDiscounts.models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long>{
    
}
