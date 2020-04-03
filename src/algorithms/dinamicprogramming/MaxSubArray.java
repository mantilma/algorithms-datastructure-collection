package algorithms.dinamicprogramming;

public class MaxSubArray {
	public static int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution arrayyy
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
    }
    
    public static void main (String[] args) {
    	System.out.println(solve(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
