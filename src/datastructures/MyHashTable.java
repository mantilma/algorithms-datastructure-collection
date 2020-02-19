package datastructures;

import java.util.ArrayList;

public class MyHashTable<K,V> {
	private ArrayList<Node <K,V>> bucket;
	private int numBuckets;
	private int size;
	
	public MyHashTable() {
		bucket = new ArrayList<>();
		numBuckets = 10;
		size = 0;
		
		for (int i = 0; i < numBuckets; i++) {
			bucket.add(null);
		}		
	}
	
	//hash function to find bucket index
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		if (index < 0) index *= -1;
		return index;
	}
	
	public V remove (K key) {
		int index = getBucketIndex(key);
		Node<K,V> head = bucket.get(index);
		Node<K,V> prev = null;
		
		while (head != null) {
			if (head.key.equals(key)) // remove
			{
				if (prev == null) {
					//it means is the first element of the linkedlist
					bucket.set(index, head.next);
				}
				else {
					//it means its an element in the middle of the linkedlist
					prev.next = head.next;
				}
				
				size--;
				return head.value;
			}

			prev = head;
			head = head.next;
		}
		
		return null;
	}
	
	public V add (K key, V value) {
		int index = getBucketIndex(key);
		Node<K,V> newElement = new Node<K,V>(key, value);
		Node<K,V> head = bucket.get(index);
		
		//check if the key is already present
		while(head != null) {
			if (head.key.equals(key)) {
				return null;
			}
			head = head.next;
		}
		
		//add on top of the linked list
		head = bucket.get(index);
		newElement.next = head;
		bucket.set(index, newElement);
		size++;
		
		return value;
	}
	
	public V get (K key) {
		int index = getBucketIndex(key);
		Node<K,V> head = bucket.get(index);
		
		while (head != null) {
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}
		
		return null;
	}
	
	public static void main (String[] args) {
		MyHashTable<String, Integer> rubrica = new MyHashTable<String, Integer>();
		rubrica.add("Filippo Verdi", 1);
		rubrica.add("Mario Rossi", 2);
		System.out.println(rubrica.size);
		rubrica.remove("Filippo Verdi");
		System.out.println(rubrica.size);
		
	}
}

class Node<K,V> {
	K key;
	V value;
	Node<K,V> next;
	
	public Node (K key, V value) {
		this.key = key;
		this.value = value;
	}
}
