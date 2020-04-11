package algorithms.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void insertionSort(int array[]) {
		
		for (int i=1; i <array.length; i++) {
			int element = array[i];
			
			for (int j = i - 1; j >= 0; j--) {
				if (element >= array[j]) break;
				int tmp = array[j];
				array[j] = element;
				array[j+1] = tmp;				
			}
		}
	}
	
	public static void main (String[] args) {
		int[] input = new int[] {4,3,2,10,5};
		insertionSort(input);
		System.out.println(Arrays.toString(input));
	}
}
