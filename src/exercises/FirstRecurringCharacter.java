package exercises;

import java.util.HashSet;
import java.util.Set;

/*
 * Google Question
 * Given an array = [2,5,1,2,3,5,1,2,4]:
 * It should return 2
 *
 * Given an array = [2,1,1,2,3,5,1,2,4]:
 * It should return 1
 *
 * Given an array = [2,3,4,5]:
 * It should return undefined
 * 
 */
public class FirstRecurringCharacter {
	public static int function (int[] input) {
		Set<Integer> map = new HashSet<Integer>();
		for (int number: input) {
			if(!map.add(number)) return number;
		}
		throw new IllegalArgumentException("no number found");
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {2,1,0,5,3,5,1,2,4};
		System.out.println(function(input));
	}
}
