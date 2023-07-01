package com.storediscounts.StoreDiscounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.storediscounts.StoreDiscounts.models.Card;

@Repository
public interface  CardRepository extends JpaRepository<Card,Long> {
    
      @Query(value = "SELECT Top(1) * FROM CARD u WHERE u.id = ?1 ",
    nativeQuery = true)
    Card findCard(int id);
   
}
