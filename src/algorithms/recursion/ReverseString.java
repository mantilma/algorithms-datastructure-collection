package algorithms.recursion;

import java.util.Arrays;

/*
 * Write a function that reverses a string recursively.
 * 
 * Complessità per soluzione ricorsiva: tempo O(n) spazio per mem stack O(n)
 * 
 * Complessità per soluzione iterativa: tempo O(n) spazio O(1)
 */
public class ReverseString {
	
	public void reverseString(String s) {
		char[] c = s.toCharArray();
		reverseRecursive(c, 0, c.length-1);
		System.out.println(Arrays.toString(c));
		c = s.toCharArray();
		
		reverseStringIterative(c);
		System.out.println(Arrays.toString(c));
	}
	
	private void reverseRecursive(char[] c, int left, int right) {
		if (left >= right) return; //passo base

		reverseRecursive(c, left+1, right-1); //passo ricorsivo
		char tmp = c[left];
		c[left] = c[right];
		c[right] = tmp;
				
	}
	
    public void reverseStringIterative(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
	
	public static void main (String[] args) {
		
		new ReverseString().reverseString("ciao marco");
	}
}
