package algorithms.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * DFS in a graph.
 * 
 * input con adjencylist: 
 * 0: 2 -> 1
 * 1: 0 -> 2 -> 4
 * 2: 0 -> 1 -> 3
 * 3: 2
 * 4: 1
 * 
 * output con source node 2: 2, 0, 1, 4, 3
 */
public class DFSInGraph {
	public static void DFS (LinkedList<Integer>[] graph, int sourcenode) {
		HashSet<Integer> visited = new HashSet<>();
		DFSUtil(graph, sourcenode, visited);
	}
	
	private static void DFSUtil (LinkedList<Integer>[] graph, int sourcenode, HashSet<Integer> visited ) {
		System.out.println(sourcenode);
		visited.add(sourcenode);
		
		LinkedList<Integer> adjencyVertixList = graph[sourcenode];
		
		while(!adjencyVertixList.isEmpty()) {
			Integer adjencyVertix = adjencyVertixList.remove();
			if (!visited.contains(adjencyVertix)) {
				DFSUtil(graph, adjencyVertix, visited);
			}
		}
	}
	
	public static void main (String[] args) {
		LinkedList<Integer> graph[] = new LinkedList[5];
		for (int i=0; i<5; ++i) 
            graph[i] = new LinkedList();
		
		graph[0].add(2);
		graph[0].add(1);
		
		graph[1].add(0);
		graph[1].add(2);
		graph[1].add(4);
		
		graph[2].add(0);
		graph[2].add(1);
		graph[2].add(3);
		
		graph[3].add(2);
		
		graph[4].add(1);
		
		DFS(graph, 2);
		
		graph[0].add(2);
		graph[0].add(1);
		
		graph[1].add(0);
		graph[1].add(2);
		graph[1].add(4);
		
		graph[2].add(0);
		graph[2].add(1);
		graph[2].add(3);
		
		graph[3].add(2);
		
		graph[4].add(1);
		
		DFS(graph, 1);
	}
	
}
