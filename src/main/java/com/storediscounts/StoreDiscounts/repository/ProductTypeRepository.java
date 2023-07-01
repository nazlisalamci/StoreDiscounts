package com.storediscounts.StoreDiscounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.storediscounts.StoreDiscounts.models.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType,Long>{
        @Query(value = "SELECT Top(1) * FROM PRODUCT_TYPE  u WHERE u.id = ?1 ",
    nativeQuery = true)
    ProductType findProductType(int id);
   
    
}
