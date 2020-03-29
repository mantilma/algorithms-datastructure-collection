package algorithms.recursion;

import java.util.Arrays;

public class Permutations {
	public static void permutations (int[] nums, int startIndex, int endIndex) {
		
		if (startIndex == endIndex) System.out.println(Arrays.toString(nums));
		
		else {
			for (int i = startIndex; i <= endIndex; i++) {
				swap(nums, startIndex, i);
				permutations(nums, startIndex + 1, endIndex);
				swap(nums, startIndex, i);
			}
		}
	}
	
	//funzione che scambia nums[i] con nums[j]
	private static void swap (int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
	}
	
	public static void main (String[] args) {
		permutations(new int[] {3,2,7}, 0 , 2);
	}
}
