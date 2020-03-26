package algorithms.search;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * BFS in a graph.
 * 
 * input con adjencylist: 
 * 0: 2 -> 1
 * 1: 0 -> 2 -> 4
 * 2: 0 -> 1 -> 3
 * 3: 2
 * 4: 1
 * 
 * output con source node 2: 2, 0, 1, 3, 4
 * 
 * tips: è sostanzialmente uguale alla BFS fatta in un tree soltanto nei grafo potrei visitare due volte lo stesso
 * nodo se non tengo traccia di quelli già visitati.
 */
public class BFSInGraph {
	private static void BFS (LinkedList<Integer>[] adj, int sourceNode) { //in ingresso ho un grafo rappresentato da un array di list (adjency list)
		HashSet<Integer> visited = new HashSet<>();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(sourceNode);
		visited.add(sourceNode);

		while (!queue.isEmpty()) {
			// Dequeue a vertex from queue and print it
			sourceNode = queue.remove();		
			System.out.println(sourceNode);
			
			// Get all adjacent vertices of the dequeued vertex
			LinkedList<Integer> temp = adj[sourceNode];
			
			for (Integer adjecentVertice: temp) {
				if (visited.contains(adjecentVertice)) continue;
				
				queue.add(adjecentVertice);
				visited.add(adjecentVertice);
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
		
		BFS(graph, 2);
		BFS(graph, 1);
	}
}
