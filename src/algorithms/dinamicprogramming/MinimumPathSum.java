package algorithms.dinamicprogramming;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/
//problema di minimizzazione... programmazione dinamica... problema simile ma piu semplificato del multistage graph del prof indiano su youtube
public class MinimumPathSum {
	public static int minimumPathSum (int[][] grid) {
		if (grid == null || grid.length == 0) return 0;
		
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int[][] sol = new int[m][n];
	    sol[0][0] = grid[0][0];
	    
	    //inizializzo la prima riga
	    for (int j = 1; j < n; j++) {
	    	sol[0][j] = sol[0][j-1] + grid[0][j];
	    }
	    
	    //inizializzo la prima colonna
	    for (int i = 1; i < m; i++) {
	    	sol[i][0] = sol[i-1][0] + grid[i][0];
	    }
	    
	    //riempire le restanti caselle
	    for (int i = 1; i < m; i++) {
	    	for (int j = 1; j < n; j++) {
	    		if(sol[i-1][j] > sol[i][j-1]){
	    			sol[i][j] = sol[i][j-1] + grid[i][j];
	            }else{
	            	sol[i][j] = sol[i-1][j] + grid[i][j];
	            }
	        }
	    }
	 
	    return sol[m-1][n-1];
	}
}
