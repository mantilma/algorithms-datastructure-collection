package algorithms.backtracking;

import java.util.HashMap;

/*
 * Find Sets Of Numbers That Add Up To 16
 * 
 * Input: [2,4,6,10]
 * Output: {6,10} {2,4,10} --> output 2
 * 
 * Assume: array ordered, no duplicate, input 0 output 1 ovvero {}
 * 
 * APPROCCIO: questo è un problema dove voglio trovare tutte le possibili soluzioni e le voglio tutte non una in particolare. 
 * Quindi approccio backtracking.
 * Ricordarsi che se successivamente noto che si presentano gli stessi sottoproblemi utilizzare tecnica di programmazione 
 * dinamica recursion + memoization
 * approccio top-down.
 */
public class FindsSetOfNumberAddUpTo {
	public static int dpMemoitazion (int[] input, int total, int i, HashMap<String, Integer> mem) {
		String key = total + ":" + i;
		if (mem.containsKey(key)) {
			return mem.get(key);
		}
		if (total == 0) return 1;
		if (total < 0) return 0;
		if (i<0) return 0;
		
		int result = 0;
		if (total < input[i]) result = dpMemoitazion(input, total, i-1, mem);
		else {
			result = dpMemoitazion(input, total - input[i], i - 1, mem) + 
					 dpMemoitazion(input, total, i - 1, mem);
		}
		mem.put(key, result);
		return result;
	}
	
	public static void main (String[] args) {
		int[] input = {2,4,6,10};
		int result = dpMemoitazion(input, 16, 3, new HashMap<String, Integer>());
		System.out.println(result);
	}
}
