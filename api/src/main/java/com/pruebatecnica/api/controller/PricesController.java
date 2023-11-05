package com.pruebatecnica.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.pruebatecnica.api.model.Prices;
import com.pruebatecnica.api.service.PriceService;


@RestController
@RequestMapping("/api/price")
@CrossOrigin(origins = "http://localhost:4200")
public class PricesController {

	@Autowired
	private PriceService priceService;

	@GetMapping("/obtenerproductos/{applicationDate}/{productId}/{brandId}")
		public ResponseEntity<List<Map<String, Object>>> listByFields(@PathVariable("applicationDate") String applicationDate,@PathVariable("productId") String productId,@PathVariable("brandId") String brandId) {
			try {
			List<Prices> prices = priceService.findLikeDateProductChain(applicationDate,productId,brandId);
			
			List<Map<String, Object>> pricesModified = new ArrayList<>();
			for (Prices p :prices){
				Map<String, Object> mp =this.convertPricetoMap(p);
				pricesModified.add(mp);
			}

			return ResponseEntity.ok(pricesModified);
			}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}

		}

		public Map<String, Object> convertPricetoMap(Prices prices){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productId",prices.getProduct_id());
			map.put("brandId",prices.getBrand().getId());
			map.put("priceList",prices.getPrice_list());
			map.put("startDate",prices.getStart_date());
			map.put("endDate",prices.getEnd_date());
			map.put("price",prices.getPrice());
			return map;
		}
	
}
