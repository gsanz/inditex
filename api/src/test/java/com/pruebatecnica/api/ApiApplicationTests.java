package com.pruebatecnica.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

import com.pruebatecnica.api.model.Prices;
import com.pruebatecnica.api.service.PriceService;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApiApplicationTests {

    @Autowired
    private PriceService priceService;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH.mm.ss");
	@Test
	void contextLoads() {
	}

	@Test
	void test1() {
		LocalDateTime dateInput = LocalDateTime.of(2020, 06, 14, 10, 00, 00);
		List<Prices> prices = priceService.findLikeDateProductChain( "2020-06-14 10:00:00","35455","1");
		Iterator<Prices> pricesIterator = prices.iterator();
		while(pricesIterator.hasNext()) {
			Prices price =pricesIterator.next();
			assertEquals(price.getProduct_id(),35455);
			assertEquals(price.getBrand().getId(),1);
			LocalDateTime dateStart= LocalDateTime.parse(price.getStart_date(), dtf);
			LocalDateTime dateEnd= LocalDateTime.parse(price.getEnd_date(), dtf);
			assertTrue(dateInput.isAfter(dateStart));
			assertTrue(dateInput.isBefore(dateEnd));
		}
	}

	@Test
	void test2() {
		LocalDateTime dateInput = LocalDateTime.of(2020, 06, 14, 16, 00, 00);
		List<Prices> prices = priceService.findLikeDateProductChain( "2020-06-14 16:00:00","35455","1");
		Iterator<Prices> pricesIterator = prices.iterator();
		while(pricesIterator.hasNext()) {
			Prices price =pricesIterator.next();
			assertEquals(price.getProduct_id(),35455);
			assertEquals(price.getBrand().getId(),1);
			LocalDateTime dateStart= LocalDateTime.parse(price.getStart_date(), dtf);
			LocalDateTime dateEnd= LocalDateTime.parse(price.getEnd_date(), dtf);
			assertTrue(dateInput.isAfter(dateStart));
			assertTrue(dateInput.isBefore(dateEnd));
		}
	}
 
	@Test
	void test3() {
		LocalDateTime dateInput = LocalDateTime.of(2020, 06, 14, 21, 00, 00);
		List<Prices> prices = priceService.findLikeDateProductChain( "2020-06-14 21:00:00","35455","1");
		Iterator<Prices> pricesIterator = prices.iterator();
		while(pricesIterator.hasNext()) {
			Prices price =pricesIterator.next();
			assertEquals(price.getProduct_id(),35455);
			assertEquals(price.getBrand().getId(),1);
			LocalDateTime dateStart= LocalDateTime.parse(price.getStart_date(), dtf);
			LocalDateTime dateEnd= LocalDateTime.parse(price.getEnd_date(), dtf);
			assertTrue(dateInput.isAfter(dateStart));
			assertTrue(dateInput.isBefore(dateEnd));
		}
	}
}
