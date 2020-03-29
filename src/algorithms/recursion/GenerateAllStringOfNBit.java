package algorithms.recursion;

import java.util.Arrays;

/*
 * n = 3
 * Output:
 * [0, 0, 0]    [1, 0, 0]    [0, 1, 0]    [1, 1, 0]
 *
 * [0, 0, 1]     [1, 0, 1]     [0, 1, 1]    [1, 1, 1]
 */
public class GenerateAllStringOfNBit {
	public static void print(int n) {
		int[] arr = new int[n];
		printRecursion(arr, n);
	}
	public static void printRecursion(int[] arr, int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arr));
		} else {
			arr[n - 1] = 0;
			printRecursion(arr, n - 1);
			arr[n - 1] = 1;
			printRecursion(arr, n - 1);
		}
	}
	
	public static void main(String[] args) {
		print(4);
	}
}
