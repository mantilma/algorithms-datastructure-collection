package exercises;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        
		int i = 0, j = 0, k = 0;
        int[] solution = new int[m+n];
        while(i<m && j<n) {
            solution[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        
        while(i<m) {
            solution[k++] = nums1[i++];
        }
        
        while(j<n) {
            solution[k++] = nums2[j++];
        }
        
        return solution;
    }
	
	public static void main (String[] args) {
		int[] array1 = new int[] {1,2,3};
		int[] array2 = new int[] {0,5,6};
		System.out.println(Arrays.toString(merge(array1, 3, array2, 3)));
	}
}
