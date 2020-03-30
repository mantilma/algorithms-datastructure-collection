package algorithms.dinamicprogramming;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 or 3 steps. In how many distinct ways can you climb to the top?

	Note: Given n will be a positive integer.

	Example 1:

	Input: 2
	Output: 2
	Explanation: There are two ways to climb to the top.
	1. 1 step + 1 step
	2. 2 steps

	Example 2:

	Input: 3
	Output: 3
	Explanation: There are three ways to climb to the top.
	1. 1 step + 1 step + 1 step
	2. 1 step + 2 steps
	3. 2 steps + 1 step

	//Ragionamento: apparentemente non mi sembra un problema che posso risolvere con la programmazione dinamica
	 * perchè:
	 * non voglio UNA sola soluzione ottima (max o min) ma tutte le soluzioni possibili.
	 * Quindi mi serve la tecnica del backtracking (DFS, state space tree, condizione di 
 * 
 */
public class ClimbStairs {
	//ricorsion top down: complessita temporaleO(3^n), spaziale O(n) 
	public static int climbStairs (int scale, int passi) {
		if (passi > scale) return 0;
		if (passi == scale) return 1;
		
		return climbStairs(scale, passi + 1) + climbStairs(scale, passi + 2) + climbStairs(scale, passi + 3);
	}
	
	//miglioramento della soluzione ricorsiva top down con memoization: complessita temporaleO(n), spaziale O(n)
	public static int climbStairsMem (int scale, int passi, int memo[]) {
		if (passi > scale) return 0;
		if (passi == scale) return 1;
		if (memo[passi] > 0) return memo[passi];
		return memo[passi] = climbStairs(scale, passi + 1) + climbStairs(scale, passi + 2) + climbStairs(scale, passi + 3);
	}
	
	//approccio bottom up, costruisco array dal basso verso l'alto iterativamente: o(n) o(n)
	public static int climbStairsBottomUp (int scale) {
		if (scale == 1) {
			return 1;
		}
		int[] dp = new int[scale + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= scale; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[scale];
		
	}
	
	//approccio bottom up, costruisco array dal basso verso l'alto iterativamente senza salvataggio di tutto l'array dp: o(n) o(1)
	public static int climbStairsBottomUp2 (int scale) {
		if (scale == 1) {
			return 1;
		}
		int[] dp = new int[scale + 1];
		int first = 1;
		int second = 2;
		int third = 4;
		for(int i = 4; i <= scale; i++) {
			int fourth = first + second + third;
			first = second;
			second = third;
			third = fourth;
		}
		return third;
		
	}
	
	
	public static void main (String[] args) {
		System.out.println(climbStairs(5,0));
		System.out.println(climbStairsMem(5,0,new int[6]));
		System.out.println(climbStairsBottomUp(5));
		System.out.println(climbStairsBottomUp2(5));
	}
}
