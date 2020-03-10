package com.genoapay.stocksystem;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.genoapay.service.StockService;

@SpringBootTest
class StocksystemApplicationTests {

	static StockService stockService;
	
	@BeforeAll
	static void setup() {
		stockService = new StockService();
	}
	
	@Test
	@DisplayName("Normal flow in the Code Challenge (Buy=5, Sell=11)")
	void normalFlow() {
		int prices[] = {10, 7, 5, 8, 11, 9};		
		assertEquals(6, stockService.getMaxProfit(prices),"Its not the same");
			
	}
	
	@Test
	@DisplayName("Multiple profits with same values (Buy=2, Sell=8)")
	void havingMultipleSameProfits() {
		int prices[] = {2, 8, 5, 6, 2, 8, 5, 6, 2, 8};
		assertEquals(6, stockService.getMaxProfit(prices),"Its not Zero");
		
	}
	
	@Test
	@DisplayName("All same prices (Flat Market) - so profit is 0 (Buy=4, Sell=4)")
	void allSameValues() {
		int prices[] = {4, 4, 4, 4, 4, 4};
		assertEquals(0, stockService.getMaxProfit(prices),"Its not Zero");
		
	}
	
	
	@Test
	@DisplayName("All loses (Market tumbles)- must return one with the least profit loss (negative values)")
	void descendingValues() {
		int prices[] = {25, 19, 17, 14, 13, 5, 2, 0};
		assertEquals(-1, stockService.getMaxProfit(prices));
		
		
	}
	
	@Test
	@DisplayName("Not enough prices supplied in Array")
	void notEnoughValues() {
		int prices1[] = {}; // No Values
		assertEquals(0, stockService.getMaxProfit(prices1));
		
		int prices2[] = {25}; // One Value
		assertEquals(0, stockService.getMaxProfit(prices2));
		
	}
	
	

}
