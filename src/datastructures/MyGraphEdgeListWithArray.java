package datastructures;

import java.util.ArrayList;
import java.util.Arrays;

public class MyGraphEdgeListWithArray {
	public static void main (String[] args) {
		ArrayList<int[]> edgeList = new ArrayList<>();
		edgeList.add(new int[] {0,2});
		edgeList.add(new int[] {2,3});
		edgeList.add(new int[] {2,1});
		edgeList.add(new int[] {1,3});
		for (int[] array: edgeList) {
			System.out.println(Arrays.toString(array));
		}
	} 
	
	
	
}
