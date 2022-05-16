package com.searchhub.services.ProductBackendDBHandlerService.Repository;

import com.searchhub.services.ProductBackendDBHandlerService.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProductRepository extends JpaRepository<Products, BigInteger> {
}
