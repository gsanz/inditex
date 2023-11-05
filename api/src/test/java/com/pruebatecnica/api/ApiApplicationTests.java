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
		System.out.println("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
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
		System.out.println("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
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
		System.out.println("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)");
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

	@Test
	void test4() {
		System.out.println("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)");
		LocalDateTime dateInput = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
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

	@Test
	void test5() {
		System.out.println("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)");
		LocalDateTime dateInput = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
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
