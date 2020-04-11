package algorithms.sort;

import java.util.Arrays;

//la complessità temporale è 2T(n/2) + n = nlgn. Complessità spaziale O(n)
public class MergeSort {
	public static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int midIndex = (leftIndex + rightIndex) / 2;
			mergeSort(arr, leftIndex, midIndex);
			mergeSort(arr, midIndex+1, rightIndex);
			merge(arr,leftIndex, midIndex, rightIndex);
		}
	}
	
	//si tratta di fare il merge due array ciascuno ordinato.
	//il primo array ordinato. arr[leftIndex...midIndex]
	//il secondo array ordinato arr[midIndex+1...rightIndex]
	private static void merge (int[] arr, int leftIndex, int midIndex, int rightIndex) {
		
		// Find sizes of two subarrays to be merged 
        int n1 = midIndex - leftIndex + 1; 
        int n2 = rightIndex - midIndex; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2];
        
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[leftIndex + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[midIndex + 1+ j]; 
        
        /* Merge the temp arrays */
        
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;
  
        // Initial index of merged subarry array 
        int k = leftIndex;
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        
	}
	
	public static void main (String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		mergeSort(arr, 0 , arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
