package algorithms.recursion;

import java.util.Arrays;

public class ReverseString {
	
	public void reverseString(String s) {
		char[] c = s.toCharArray();
		reverse(c, 0, c.length-1);
		System.out.println(Arrays.toString(c));
	}
	
	private void reverse(char[] c, int left, int right) {
		if (left >= right) return; //passo base

		reverse(c, left+1, right-1); //passo ricorsivo
		char tmp = c[left];
		c[left] = c[right];
		c[right] = tmp;
				
	}
	
	public static void main (String[] args) {
		
		new ReverseString().reverseString("ciao marco");
	}
}
