package algorithms.dinamicprogramming;

public class fibonacci {
	public static Integer fibonacciTopUpRecursive (Integer number, Integer[] temp) {
		if (temp[number] != null) return temp[number];
		if (number == 1 || number == 2) return 1;
		else temp[number] = fibonacciTopUpRecursive(number - 1, temp) + fibonacciTopUpRecursive(number - 2, temp);
		return temp[number];
		
	}
	
	public static Integer fibonacciBottomUpRecursive (Integer number) {
		if (number == 1 || number == 2) return 1;
		Integer[] temp = new Integer[number + 1];
		temp[1] = 1;
		temp[2] = 1;
		for (int i = 3; i <= number; i++) {
			temp[i] = temp[i-1] + temp[i-2];
		}
		return temp[number];
	}
	
	public static void main (String args[]) {
		System.out.println(fibonacciTopUpRecursive(8, new Integer[9]));
		System.out.println(fibonacciBottomUpRecursive(8));
	}
}
