package algorithms.backtracking;

import java.util.Arrays;

/* You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3 
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * 
 */
public class FewestCoinChange {
	
	//questo mi darebbe tutte le possibili combinazioni di cambi ovvero:
	// input {1,2,5}
	// output = 9 ovvero {5},{2,2,1},{2,1,2},{2,1,1,1},{1,2,2},{1,2,1,1},{1,1,2,1},{1,1,1,2},{1,1,1,1,1}
	public static int functionTopDownMemoization(int[] coins, int amount) {
		if (amount == 0) return 1;
		if (amount < 0) return 0;
		
		int output = 0;
		for (int coin : coins) {
		  output += functionTopDownMemoization(coins, amount - coin);
		}
		
		return output;
	}

	/* ma io voglio la soluzione migliore!
	 * il return del passo base non indica piu +1 sul totale delle soluzioni trovate ma se trovo (1) o non trovo (0) 
	 * una soluzione e solo se ho trovato la soluzione ed è la soluzione minima tra quelle trovate allora la posso restituire
	 */
	private static int coinChange(int[] coins, int amount) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;

		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, amount - coin);
			if (res >= 0 && res < min)
				min = 1 + res;
		}

		return (min == Integer.MAX_VALUE) ? -1 : min;
	}

	//Ma io voglio memorizzare soluzioni già calcolate
	private static int coinChange(int[] coins, int amount, int[] mem) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;
		if (mem[amount-1] != 0) return mem[amount-1];
		
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, amount - coin);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		mem[amount-1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return mem[amount-1];
	}
	
	/* Ma la vera programmazione dinamica è quella bottom-up. Si ragiona così:
	 * io all'11-esimo soldo ci arrivo in tre modi:
	 * 1 - partendo dal 10 ecimo soldo con una moneta da 1
	 * 2 - partendo dal 9 soldo e aggiungendo una moneta da 2
	 * 3 - partendo dal 6 soldo e aggiungendo una moneta da 5
	 * 
	 * Altro esempio al passo f(5) io avro:
	 * f(5) = min {f(5 - 1), f(5 -2), f(5-5)} + 1;
	 * f(5) = min {f(4), f(3), f(0)} + 1
	 * 
	 * I passi base saranno:
	 * f(0) = 0
	 * f(1) = 1   perche solo con una moneta da 1
	 * f(2) = min {0 , 1 } + 1 = 1   (perche f(-1) non esiste)
	 *
	 * complessità tempo O (s*n)
	 * complessità spazio O (s)
	 */
	public static int bottomUp (int[] coins, int amount) {
	    //creo l'array 
		int max = amount + 1;
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, max);
	    //inizializzo l'array con il passo base
	    dp[0] = 0;
	    
	    //riempimento array incrementale partendo da f(1)
	    for (int i = 1; i <= amount; i++) {
	      for (int j = 0; j < coins.length; j++) {
	        if (coins[j] <= i) {
	          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
	        }
	      }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
	  }
	
	public static void main (String[] args) {
		System.out.println(functionTopDownMemoization(new int[] {1,2,5}, 5));
		System.out.println(coinChange(new int[] {1,2,5}, 11));
		//System.out.println(functionTopDownMemoization2(new int[] {1,2,5}, 11, 11));
		
	}
}
