package algorithms.search;

public class BinarySearch {
	public static int binarySearch(int[] a, int x) {
		int index_low = 0;
		int index_medium = 0;
		int index_high = a.length - 1;
		
		while (index_low <= index_high) {
			index_medium = (index_high + index_low) / 2;
			if (a[index_medium] < x) 
				index_low = index_medium + 1;
			else if (a[index_medium] > x) 
				index_high = index_medium - 1;
			else return index_medium;
		}
		
		return -1;
	}
	
	public static int binarySearchRecursive(int[] a, int x, int low, int high) {
		if (low > high) return -1;
		
		int index_medium = (low + high) / 2;
		if (a[index_medium] < x)
			return binarySearchRecursive(a, x, index_medium + 1, high);
		else if (a[index_medium] > x)
			return binarySearchRecursive(a, x, low, index_medium - 1);
		
		else return index_medium;
		
	}
	
	public static void main (String[] args) {
		int a[] = new int[] {3, 7, 10, 14, 19, 20 ,25, 26, 32};
		System.out.println(binarySearch(a, 34));
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearchRecursive(a, 34, 0, a.length - 1));
		System.out.println(binarySearchRecursive(a, 26, 0, a.length - 1));
	}
}
