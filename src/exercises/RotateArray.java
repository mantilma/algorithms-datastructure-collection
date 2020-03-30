package exercises;

import java.util.Arrays;

//NON FUNZIONA PER ARRAY PARI!!!! DA PERFERZIONARE
public class RotateArray {
	public static void rotate(int[] nums, int k) {
		int i = 0;
        int currentIndex = 0;
        int currentNumber = nums[currentIndex];
        while (i < nums.length) {
            int newIndex = (currentIndex + k) % nums.length;
            
            int tmpNumber = nums[newIndex];
            nums[newIndex] = currentNumber;
            
            currentNumber = tmpNumber;
            currentIndex = newIndex;
            i++;
        }
    }
	
	public static void main (String[] args) {
		int[] input = new int[] {1,2,3,4,5,6};
		rotate(input, 2);
		System.out.println(Arrays.toString(input));
		input = new int[] {1,2,3,4,5,6,7};
		rotate(input, 3);
		System.out.println(Arrays.toString(input));
	}
}
