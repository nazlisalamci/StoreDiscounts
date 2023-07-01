package com.storediscounts.StoreDiscounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.storediscounts.StoreDiscounts.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
     @Query(value = "SELECT Top(1) * FROM CUSTOMER u WHERE u.id = ?1 ",
    nativeQuery = true)
    Customer findCustomer(int id);

}
