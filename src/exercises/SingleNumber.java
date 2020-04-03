package exercises;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1

Example 2:

Input: [4,1,2,1,2]
Output: 4


BITMANIPULATION: a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
*/
public class SingleNumber {
	public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
	
	public static void main (String[] args) {
		System.out.println(singleNumber(new int[] {1,2,2,4,1}));
	}
}
