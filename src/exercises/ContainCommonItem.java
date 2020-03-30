package exercises;

import java.util.HashSet;
import java.util.Set;

/*
 * Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items
 * For Example:
 * const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'i'];
 * should return false.
 * -----------
 * const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'x'];
 * should return true.
 *
 * 2 parameters - arrays - no size limit
 * return true or false
 * 
 * Complessità: time O(n) spazio O(n)
 */
public class ContainCommonItem {
	public static boolean containCommonItem (int[] array1, int[] array2) {
		Set<Integer> tmp = new HashSet<>();
		for (int number: array1) {
			tmp.add(number);
		}
		
		for (int number: array2) {
			if (tmp.contains(number)) return true;
		}
		
		return false;
	}
	
	public static void main (String[] args) {
		System.out.println(containCommonItem(new int[] {1, 2, 3}, new int[] {4, 5, 6}));
		System.out.println(containCommonItem(new int[] {1, 2, 3}, new int[] {4, 5, 3}));
		
	}
}
