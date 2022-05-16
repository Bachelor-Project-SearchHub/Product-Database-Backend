package com.searchhub.services.ProductBackendDBHandlerService.Repository;

import com.searchhub.services.ProductBackendDBHandlerService.Entity.Webpages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface WebpageRepository extends JpaRepository<Webpages, BigInteger> {
}
