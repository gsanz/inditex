package com.pruebatecnica.api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pruebatecnica.api.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    
    
}