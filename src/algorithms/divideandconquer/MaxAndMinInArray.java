package algorithms.divideandconquer;

import java.util.Arrays;

public class MaxAndMinInArray {
	
	//t(n) = 2T(n/2) + O(1)
	public static int[] MaxMinInArray (int[] input, int startIndex, int endIndex) {
		int max;
		int min;
		//RISOLUZIONE PROBLEMA AL PASSO BASE
		if (startIndex == endIndex) {
			max = input[startIndex];
			min = input[endIndex];
		}
		
		else {
			//DIVIDE
			int mid = (startIndex + endIndex) / 2;
			int left[] = MaxMinInArray(input, startIndex, mid);
			int right[] = MaxMinInArray(input, mid + 1, endIndex);
			//CONQUER
			if (left[0] > right[0]) {
				max = left[0];
			}
			else {
				max = right[0];
			}
			if (left[1] < right[1]) {
				min = left[1];
			}
			else {
				min = right[1];
			}
		}
		
		int[] result = {max,min};
		return result;
		
	}
	
	public static void main (String[] args) {
		Integer max = 0;
		Integer min = 0;
		int[] input = new int[] {3,9,1,-5,20,8};
		
		int[] result = MaxMinInArray(input, 0, input.length - 1);
		System.out.println(Arrays.toString(result));
	}
}
