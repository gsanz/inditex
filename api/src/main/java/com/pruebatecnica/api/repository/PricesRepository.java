package com.pruebatecnica.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pruebatecnica.api.model.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer>{

	@Query(value = "SELECT * FROM prices WHERE start_date < ?#{[0]} AND end_date > ?#{[0]} AND product_id = ?#{[1]} AND brand_id=?#{[2]}", nativeQuery = true)
	public List<Prices> findLikeDateProductChain(String applicationDate, String productId, String brandId );


	public List<Prices> findAllByOrderByIdAsc();
}