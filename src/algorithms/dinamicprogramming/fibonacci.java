package algorithms.dinamicprogramming;

public class fibonacci {
	
	//memoization top-up. parto da f(5) e richiamo ricorsivamente f(4) + f(3) ecc...
	public static Integer fibonacciTopUpRecursive (Integer number, Integer[] temp) {
		if (temp[number] != null) return temp[number];
		if (number == 1 || number == 2) return 1;
		else return temp[number] = fibonacciTopUpRecursive(number - 1, temp) + fibonacciTopUpRecursive(number - 2, temp);
		
	}
	
	//iterative bottom-up: la soluzione n dipende da n-1 e n-2, n-1 da n-2 e n-3. Quindi dal basso verso l'alto
	//metto nell'array i casi base e poi ciclo for calcolo tutte le altre casella dell'array.
	public static Integer fibonacciBottomUp (Integer number) {
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
		System.out.println(fibonacciBottomUp(8));
	}
}
