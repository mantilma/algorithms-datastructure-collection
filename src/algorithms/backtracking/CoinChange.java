package algorithms.backtracking;

import java.util.HashMap;

/*You are given coins of different denominations and a total amount of money. 

Write a function to compute the number of combinations that make up that amount. 

You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

Input: amount = 10, coins = [10] 
Output: 1

*/

public class CoinChange {
	
	//backtracking
	public static int coinChange(int[] input, int total, int index) {
		//System.out.println("Chiamata");
		if (total == 0) return 1;
		if (total < 0) return 0;
		if (total > 0 && index < 0) return 0;
		
		int result = 0;
		
		result = coinChange(input, total - input[index], index) + coinChange(input, total, index - 1);
		
		return result;
	}
	
	//backtracking + memoitazion
	public static int coinChange2(int[] input, int total, int index, HashMap<String, Integer> mem) {
		//System.out.println("Chiamata");
		if (total == 0) return 1;
		if (total < 0) return 0;
		if (total > 0 && index < 0) return 0;
		
		String key = total + ":" + index;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}

		int result = 0;

		result = coinChange2(input, total - input[index], index, mem) + coinChange2(input, total, index - 1, mem);
		mem.put(key, result);
		return result;
	}
	 
	public static void main (String[] args) {
		int[] input = new int[] {1,2,5};
		int total = 5;
		int index = input.length - 1;
		//System.out.println(coinChange(input, total, index));
		
		input = new int[] {1,2,5};
		total = 5;
		index = input.length - 1;
		System.out.println(coinChange2(input, total, index, new HashMap<String, Integer>()));
	}
}
