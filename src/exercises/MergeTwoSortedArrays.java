package exercises;

import java.util.Arrays;

/*
 *  Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
 *  Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}
 *
 *  Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
 *  Output: arr3[] = {4, 5, 7, 8, 8, 9}
 *   
 *  SOLUTION: time O(n1 + n2) space O(n1 + n2) dovuto all'array in piu dove salvo la soluzione    
 */
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
