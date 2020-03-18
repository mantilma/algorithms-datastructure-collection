package algorithms.recursion;

/*
fibonacci(5) = fibonacci(4) + fibonacci(3)

fibonacci(3) = fibonacci(2) + fibonacci(1)

fibonacci(4) = fibonacci(3) + fibonacci(2)

fibonacci(2) = fibonacci(1) + fibonacci(0)

And from fibonacci sequence 0,1,1,2,3,5,8,13,21.... we can see that 
for 5th element the fibonacci sequence returns 5

 */
public class Fibonacci {
	public int calcola(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		return calcola(n-1) + calcola (n-2);
	}
	
	public static void main (String[] args) {
		System.out.println(new Fibonacci().calcola(3));
		System.out.println(new Fibonacci().calcola(8));
	}
}
