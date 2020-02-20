package datastructures;

public class MyLinkedList {
	private Node head;
	private int size;
	
	private class Node {
		int data;
		Node next;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getFirst() {
		if (this.head == null) return -1;
		return this.head.data;
	}
	
	public int getLast() {
		if (this.head == null) return -1;
		
		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		return temp.data;
	}
	
	public int getAt (int index) {
		if (this.head == null) return -1;
		
		if (size < index || index < 0) return -1;
		
		Node temp = this.head;
		for (int i = 1; i < index; i++) {
			temp = temp.next;
		}
		
		return temp.data;
	} 
	
	public void add (int value) {
		
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = null;
		
		if (this.head == null) this.head = newNode;
		
		else {
			Node temp = this.head;
			
			while (temp.next != null) {
				temp = temp.next;
			}

			temp.next = newNode;
		}
		
		this.size++;
	}
	
	public int removeFirst() {
		if (this.size == 0) return -1;
		
		Node temp = this.head;
		this.head = this.head.next;
		this.size--;
		
		return temp.data;
	}
	
	public int removeLast() {
		if (this.size == 0) return -1;
		
		if (this.size == 1) return removeFirst();
		
		Node temp = this.head;
		Node previous = null;
		while (temp.next != null) {
			previous = temp;
			temp = temp.next;
		}
		previous.next = null;
		size--;
		return temp.data;
		
	}
	
	public int removeAt (int index) {
		if (this.size == 0) return -1;
		
		if (index > size || index < 0) return -1;
		
		if (index == 1) return removeFirst();
		
		if (index == size) return removeLast();
		
		Node temp = this.head;
		Node previous = null;
		for (int i=1; i < index; i++) {
			previous = temp;
			temp = temp.next;
		}
		
		previous = temp.next;
		return temp.data;		
	}
	
	public static void main (String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		System.out.println(list.getSize());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.removeFirst());
		
		list.add(1);
		System.out.println(list.removeFirst());
		System.out.println(list.getSize());
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		System.out.println(list.getSize());
		System.out.println(list.getFirst());
		System.out.println(list.getAt(2));
		System.out.println(list.getLast());
		
		System.out.println(list.removeLast());
		System.out.println(list.getSize());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		
		
	}
	
}
