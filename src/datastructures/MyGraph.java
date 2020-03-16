package datastructures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Implementing graph using Hashmaps and adjency list ad a rapresentation.
 * Adjency list represent vertex(or nodes) as key and edge as value in a linked list.
 * The graph is undirected ma con poche modifiche può diventare anche directed.
 */
public class MyGraph {
	
	// We use Hashmap to store the edges in the graph 
	private Map<Integer, List<Integer>> map = new HashMap<>();
	
	private void addVertex (Integer vertex) {
		this.map.put(vertex, new LinkedList<Integer>()); //potevo anche rappresentare gli edge come arraylist
	}
	
	public void addEdge (Integer vertex, Integer edge) {
		// se il mio hashmap non contiene il vertice lo inserisco
		if (!map.containsKey(vertex)) {
			addVertex(vertex);
		}
		
		// se il mio hashmap non contiente il nodo di arrivo edge allora lo inserisco
		if (!map.containsKey(edge)) {
			addVertex(edge);
		}
		
		// aggiungo alla linked list del vertice l'edge
		map.get(vertex).add(edge);
		
		//siccome il grafo è undirected aggiungo alle linked list dell'edge il vertice
		//per rappresentare anche il percorso inverso che va da edge al vertex.
		map.get(edge).add(vertex);
	}

	@Override
	public String toString() {
		return "MyGraph [map=" + map + "]";
	}
	
	public static void main(String args[]) 
    { 
		MyGraph g = new MyGraph();
		g.addEdge(0, 1);
		g.addEdge(0, 4); 
        g.addEdge(1, 2); 
        g.addEdge(1, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 3); 
        g.addEdge(3, 4);
        
        System.out.println(g);
    }
	
	
	
	
}
