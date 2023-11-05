package com.pruebatecnica.api.data;

import org.springframework.stereotype.Component;

import com.pruebatecnica.api.model.Brand;
import com.pruebatecnica.api.model.Prices;
import com.pruebatecnica.api.repository.BrandRepository;
import com.pruebatecnica.api.repository.PricesRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class dbOperationRunner implements CommandLineRunner {

    @Autowired
	private BrandRepository brandRepository; 

	@Autowired
	private PricesRepository pricesRepository; 


    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        insertData();
    }


    private  void insertData(){
        Brand zara = new Brand();
        zara.setName("Zara");
	    Brand springField = new Brand();
        springField.setName("Springfield");
        insertBrand(zara,springField);
        insertPrices(zara);
    }


    private  void insertBrand(Brand b1, Brand b2){
        brandRepository.save(b1);
		brandRepository.save(b2);
    }

    private void insertPrices(Brand b1 ){
        Prices p1 = new Prices();
        Prices p2 = new Prices();
        Prices p3 = new Prices();
        Prices p4 = new Prices();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH.mm.ss");
		p1.setBrand(b1);
		p1.setCurr("EUR");
		p1.setStart_date(dtf.format(LocalDateTime.of(2020, 06, 14, 00, 00, 00)));
		p1.setEnd_date(dtf.format(LocalDateTime.of(2023, 12, 31, 23, 59, 59)));		
		p1.setPrice_list(1);
        p1.setProduct_id(35455);
        p1.setPriority(0);
        p1.setPrice(35.50);
        p1.setCurr("EUR");

		p2.setBrand(b1);
		p2.setStart_date(dtf.format(LocalDateTime.of(2020, 06, 14, 15, 00, 00)));
		p2.setEnd_date(dtf.format(LocalDateTime.of(2020, 06, 14, 18, 30, 00)));		
		p2.setPrice_list(2);
        p2.setProduct_id(35455);
        p2.setPriority(1);
        p2.setPrice(25.45);
        p2.setCurr("EUR");

        p3.setBrand(b1);
		p3.setCurr("EUR");
		p3.setStart_date(dtf.format(LocalDateTime.of(2020, 06, 15, 00, 00, 00)));
		p3.setEnd_date(dtf.format(LocalDateTime.of(2020, 06, 15, 11, 00, 00)));		
		p3.setPrice_list(3);
        p3.setProduct_id(35455);
        p3.setPriority(1);
        p3.setPrice(30.50);
        p3.setCurr("EUR");

        p4.setBrand(b1);
		p4.setCurr("EUR");
		p4.setStart_date(dtf.format(LocalDateTime.of(2020, 06, 15, 16, 00, 00)));
		p4.setEnd_date(dtf.format(LocalDateTime.of(2020, 12, 31, 23, 59, 59)));		
		p4.setPrice_list(4);
        p4.setProduct_id(35455);
        p4.setPriority(1);
        p4.setPrice(38.95);
        p4.setCurr("EUR");




        pricesRepository.save(p1);
        pricesRepository.save(p2);
        pricesRepository.save(p3);
        pricesRepository.save(p4);
    }
    
}
