package algorithms.dinamicprogramming;

import java.util.Arrays;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *             Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 */
public class BuySellStocks {
	
	//soluzione ricorsiva top down. t(n) = 2T(n/2) + O(n) = O(nlgn)
	//O(n) è dovuto ai calcoli dei max per ogni chiamata.
	//complessità spaziale O(lgn) 
	public static int BuySellStockTopDown(int[] prices, int indexLow, int indexHigh) {
		if (indexLow >= indexHigh) return 0;
		
		int index_medium = (indexLow + indexHigh) / 2;
		int profitLeft = BuySellStockTopDown(prices, indexLow, index_medium);
		int profitRight = BuySellStockTopDown(prices, index_medium + 1, indexHigh);
		
		int minLeft = Integer.MAX_VALUE;
		for (int i = indexLow; i <= index_medium; i++) {
			minLeft = prices[i] < minLeft ? prices[i] : minLeft;
		}
		int maxRight = Integer.MIN_VALUE;
		for (int i = index_medium + 1; i <= indexHigh; i++) {
			maxRight = prices[i] > maxRight ? prices[i] : maxRight;
		}
		int profit = maxRight - minLeft;
		
		return Math.max(Math.max(profitLeft, profitRight),profit);		
	}
	/*
	public static int[] BuySellStockTopDown2(int[] prices, int indexLow, int indexHigh) {
		if (indexLow >= indexHigh) return new int[] {0, prices[indexHigh], prices[indexHigh], 1};

		int index_medium = (indexLow + indexHigh) / 2;
		int[] resultLeft = BuySellStockTopDown2(prices, indexLow, index_medium);
		int[] resultRight = BuySellStockTopDown2(prices, index_medium + 1, indexHigh);
		
		if (resultLeft[3] == 1) {
				resultLeft[2] = Integer.MIN_VALUE;
				resultLeft[3] = 0;
		}
		
		if (resultRight[3] == 1) {
			resultRight[1] = Integer.MAX_VALUE;
			resultRight[3] = 0;
		}
		//in resultLeft e resultRight salvo:
		//[0] = profitto
		//[1] = Min
		//[2] = Max
		int profit = resultRight[2] - resultLeft[1];
		
		int min = resultLeft[1] < resultRight[1] ? resultLeft[1] : resultRight[1];
		int max = resultLeft[2] > resultRight[2] ? resultLeft[2] : resultRight[2];
		
		return new int[] {(Math.max(Math.max(resultLeft[0], resultRight[0]),profit)), min,  max, 0};		
	}*/
	
	// questa soluzione costa time O(n) space O(n)
	public static int BuySellStockBottomUp(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		
		int[] profit = new int[prices.length];
		int[] min = new int[prices.length];
		profit[0] = 0;
		min[0] = prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			int profitTmp = prices[i] - min[i-1];
			
			profit[i] = profitTmp > profit[i-1] ? profitTmp : profit[i-1];
			
			min[i] = min[i-1] > prices[i] ? prices[i] : min[i-1];
			
		}
		
		return profit[prices.length - 1];
				
	}
	
	//miglioro la soluzione spaziale precedente memorizzando soltanto le ultime info 
	public static int BuySellStockBottomUp2(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		
		int lastProfit = 0;
		int lastMin = prices[0];
		
		for (int i = 1; i < prices.length; i++) {
			int profitTmp = prices[i] - lastMin;
			
			lastProfit = profitTmp > lastProfit ? profitTmp : lastProfit;
			lastMin = lastMin > prices[i] ? prices[i] : lastMin;
			
		}
		
		return lastProfit;
		
	}
	
	public static void main (String[] args) {
		System.out.println(BuySellStockTopDown(new int[] {7,1,5,3,6,4}, 0, 5));
		//System.out.println(Arrays.toString(BuySellStockTopDown2(new int[] {7,1,5,3,6,4}, 0, 5)));
		System.out.println(BuySellStockBottomUp(new int[] {7,1,5,3,6,4}));
		System.out.println(BuySellStockBottomUp2(new int[] {7,1,5,3,6,4}));
		System.out.println(BuySellStockBottomUp2(new int[] {}));
		System.out.println(BuySellStockBottomUp2(null));
	}
}
