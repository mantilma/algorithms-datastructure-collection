package algorithms.dinamicprogramming;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design 
 * an algorithm to find the maximum profit.
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
 * APPROCCIO: il fatto che devo cercare un max subito mi fa pensare alla programmazione dinamica.
 * La soluzione ottimale del problema t(n) è all'interno della soluzione dei suoi sottoproblemi max o min di t(n-1) t(n-2).
 * si:
 * We are just using the result of (n-1)th iteration in nth iteration.
 *
 *	maxval(0) = 0
 *
 *	maxval(1) = val1 - val0;
 *
 *	maxval(2) = max( (val2 - val1) , (val2 - val0), maxval(1) )
 *
 *	maxval(3) = max( (val3 - val2) , (val3 - val1), (val3 - va0) , maxval(2) )
 *
 *	maxval(4) = max( (val4 - val3), (val4 - val2) , (val4 - val1), (val4 - va0) , maxval(3) )
 *
 *	maxval(n) = max( (valn - valn- 1), (valn - valn-2), (valn - valn-3),..., (valn - val0), maxval(n - 1) )
 */
public class BuySellStocks {
	
	//soluzione ricorsiva top down DIVIDE AND CONQUER. t(n) = 2T(n/2) + O(n) = O(nlgn)
	//O(n) è dovuto ai calcoli dei max per ogni chiamata.
	//complessità spaziale O(lgn) 
	public static int BuySellStockTopDown(int[] prices, int indexLow, int indexHigh) {
		if (indexLow >= indexHigh) return 0;
		
		int index_medium = (indexLow + indexHigh) / 2;
		int profitLeft = BuySellStockTopDown(prices, indexLow, index_medium);
		int profitRight = BuySellStockTopDown(prices, index_medium + 1, indexHigh);
		
		int minLeft = Integer.MAX_VALUE;
		for (int i = indexLow; i <= index_medium; i++) {
			minLeft = prices[i] < minLeft ? prices[i] : minLeft; //prendo tra i minimi di sx (prezzo di acquisto piu basso)
		}
		int maxRight = Integer.MIN_VALUE;
		for (int i = index_medium + 1; i <= indexHigh; i++) {
			maxRight = prices[i] > maxRight ? prices[i] : maxRight; //prendo tra i massim di dx (prezzo di vendita più alto)
		}
		int profit = maxRight - minLeft;
		
		return Math.max(Math.max(profitLeft, profitRight),profit);	//restituisco il profitto massimo tra quello di sx, dx e il corrente
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
		profit[0] = 0; //array dove memorizzo i profitti massimi per ciascuno giorno. Leggero la soluzione in profit[prices.length -1]
		min[0] = prices[0]; //array dove memorizzo il prezzo minimo di acquisto
		
		for (int i = 1; i < prices.length; i++) {
			int profitTmp = prices[i] - min[i-1];
			
			//mi domando il profitto corrente è maggiore o no del profitto calcolato alla soluzione precedente
			profit[i] = profitTmp > profit[i-1] ? profitTmp : profit[i-1];
			
			//mi domando: il prezzo minimo corrente di acquisto è minore o no del prezzo minimo calcolato alla soluzione precedente
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
