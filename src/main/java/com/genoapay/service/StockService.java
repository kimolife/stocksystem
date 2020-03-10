
package com.genoapay.service;

import org.springframework.stereotype.Service;

/**
 * Utility Service for Stock Market
 *
 * @author kim.hue
 * @date 10/03/2020
 * @version 
 */
@Service
public class StockService {
	private final int MIN_PRICE_LENGTH = 2;
	/**
	 * This method gets an array of Prices (int) and 
	 * return the Max profit between 2 prices (profit = prices[j] - prices[i] (where j > i))
	 * @param prices - each element in Array is the price of the listed stock for each minute after 10:00am
	 * @return max Profit
	 */
	public int getMaxProfit(int[] prices) {
		
		// Must have enough prices to work with otherwise 0 profit returned. *Does not want to throw IllegalArgumentException for simplicity.
		if (prices.length <= MIN_PRICE_LENGTH) {
			return 0;
		}
		
		// Initiate the value when there is at least 2 prices
		int currentMax = prices[1] - prices[0];
	
		for (int i = 0; i < prices.length; i++) {
			
			//Loop through each element on the right of its current index position
			for (int j = i + 1; j < prices.length; j++ ) {
				int profit = prices[j] - prices[i];
				
				// compare the profit with the current Max Profit and replace it if its bigger
				if ( profit > currentMax ) {
					currentMax = profit;
				}
			}
		}
		
		return currentMax;
		
	}

}
