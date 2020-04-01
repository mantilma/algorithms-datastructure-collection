package algorithms.backtracking;

import java.util.Arrays;
import java.util.HashMap;

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
 * OSSERVAZIONE INIZIALE: Problema di ottimizzazione perche parliamo di fewest number of money.
 * quindi le tre tecniche che conosciamo per questo tipo di problemi sono:
 * 1 - greedy
 * 2 - dp
 * 3 - branch and bound
 * 
 * Scartiamo la greedy , perchè sappiamo che trova l'ottimalità di un problema solo in alcuni casi specifici esempio DJKSTRA
 * Scartiamo branch and bound non ancora studiata.
 * Vediamo se possiamo usare la DP. Ma prima supponiamo che io non trovo la chiave di logica per applicare la programmazione 
 * dinamica al problema allora cosa fare in questi casi? Posso pensare di utilizzare la tecnica backtracking  
 * per trovare tutte le possibili soluzioni, e tra tutte le soluzione faccio in modo di trovare LA SOLUZIONE MINIMA! 
 * Se poi mi accorgo 
 * che ci sono sotto soluzioni che si ripetono posso utilizzare la tecnica di memoitazion. 
 * Quindi deciso che utilizziamo la backtracking disegnamo l'albero di stato (state space tree)... l'albero mi permetterà 
 * di capire meglio il problema, trovare le condizioni di arresto e quindi programamre il mio codice ricorsivo meglio...
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
	
	/* backtracking soluzione migliore vecchia versione con permutazioni quindi dei calcoli inutili
	 */
	/*private static int coinChange(int[] coins, int amount) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;

		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, amount - coin);
			if (res >= 0 && res < min)
				min = 1 + res;
		}

		return (min == Integer.MAX_VALUE) ? -1 : min;
	}*/
	
	//ma io non voglio le permutazioni ovvero ai fini del problema {2,2,1} è uguale a {1,2,2}
	//space tree con permutazioni e ripetizione
	public static int fun(int[] coins, int index, int amount) {
		if (amount == 0) return 1;
		if (amount < 0) return 0;
		if (amount > 0 && index < 0) return 0;
		
		int output = 0;
		
		output = fun(coins, index - 1, amount) + fun(coins, index, amount - coins[index]);
		
		return output;
	}

	/* ma io voglio la soluzione migliore!
	 * allora trasformo il codice di prima dicendo che il return del passo base non indica piu +1 sul totale delle soluzioni 
	 * trovate ma se trovo (1) o non trovo (0) 
	 * una soluzione e solo se ho trovato la soluzione ed è la soluzione minima tra quelle trovate allora la posso restituire
	 */
	private static int coinChange(int[] coins, int index, int amount) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;
		if (amount > 0 && index < 0) return -1;

		int minLeft = Integer.MAX_VALUE;
		int minRight = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		int resLeft = coinChange(coins, index, amount - coins[index]);
		int resRight = coinChange(coins, index - 1, amount);
		
		if (resLeft >= 0 && resLeft < minLeft) {
			minLeft = 1 + resLeft;
		}
		
		if (resRight >= 0 && resRight < minRight) {
			minRight = resRight; // perchè sul nodo destro non devo aggiungere
		}
		
		min = minLeft < minRight ? minLeft : minRight; 

		return (min == Integer.MAX_VALUE) ? -1 : min;
	}

	//Ma io voglio memorizzare soluzioni già calcolate cosi risparmio chiamate!
	private static int coinChange2(int[] coins, int index, int amount, HashMap<String, Integer> mem) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;
		if (amount > 0 && index < 0) return -1;
		
		String key = amount + ":" + index;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		
		int minLeft = Integer.MAX_VALUE;
		int minRight = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		
		int resLeft = coinChange(coins, index, amount - coins[index]);
		int resRight = coinChange(coins, index - 1, amount);
		
		if (resLeft >= 0 && resLeft < minLeft) {
			minLeft = 1 + resLeft;
		}
		
		if (resRight >= 0 && resRight < minRight) {
			minRight = resRight; // perchè sul nodo destro non devo aggiungere
		}
		
		min = minLeft < minRight ? minLeft : minRight; 
		
		int result = (min == Integer.MAX_VALUE) ? -1 : min;
		mem.put(key, result);
		return result;
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
		System.out.println(functionTopDownMemoization(new int[] {1,2,5}, 11));
		System.out.println(fun(new int[] {1,2,5}, 2, 11));
		System.out.println(coinChange(new int[] {1,2,5}, 2, 303));

		System.out.println(coinChange2(new int[] {1,2,5}, 2, 303, new HashMap<String, Integer>()));
		
	}
}
