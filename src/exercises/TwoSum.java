package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * 
 * return [0, 1].
 */
public class TwoSum {
	public static int[] twoSum (int[] array1, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < array1.length; i++) {
			int complement = target - array1[i];
			if (map.containsKey(complement))return new int[] {map.get(complement), i};
			map.put(array1[i], i);
		}
		return new int[] {};
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 26)));
		System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 30)));
		
	}
}
