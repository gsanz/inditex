package com.pruebatecnica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.api.model.Prices;
import com.pruebatecnica.api.repository.PricesRepository;

@Service
public class PriceService {
    @Autowired PricesRepository pricesRepository;


    
public List<Prices> findLikeDateProductChain( String applicationDate,String productId,String brandId){ 
       List<Prices> prices = pricesRepository.findLikeDateProductChain(applicationDate,productId,brandId);    
       return prices;
    }
}
