package com.searchhub.services.ProductBackendDBHandlerService.Repository;

import com.searchhub.services.ProductBackendDBHandlerService.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface ProductRepository extends JpaRepository<Products, BigInteger> {
}
