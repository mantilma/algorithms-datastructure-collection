package exercises;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int start = 0;
		int mid = 0;
		int end = nums.length - 1;
        
		while (start <= end) {
            mid = start + (end - start) / 2;
 
            if (nums[mid] == target) return mid;
 
            else if (nums[start] <= nums[mid]) {
                /*Left sub array is sorted, check if
                key is with A[start] and A[mid] */
                if (nums[start] <= target && nums[mid] > target) {
                    /*
                      Key lies with left sorted part of array
                     */
                    end = mid - 1;
                } else {
                    /*
                    Key lies in right subarray
                     */
                    start  = mid + 1;
                }
            } else {
                /*
                 In this case, right subarray is already sorted and
                 check if key falls in range A[mid+1] and A[end]
                 */
                if (nums[mid + 1] <= target && nums[end] >= target) {
                    /*
                      Key lies with right sorted part of array
                     */
                    start = mid + 1;
                } else {
                    /*
                    Key lies in left subarray
                     */
                    end  = mid - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main (String[] args) {
    	int[] inputArray = new int[] {5,1,3};
    	int target = 3;
        int result = search(inputArray, target);
    	System.out.println(result);
    }
}
