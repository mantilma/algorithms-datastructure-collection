package datastructures;

//Java program to Implement a queue 
//using singly linked list
//The main Stack's characteristic is that insert and delete happens on different sides
public class MyQueue<T> {
	private class Node {
		T value;
		Node next;
	}
	
	private Node head, tail;
	
	//add the element in the tail of the list
	public void enqueue (T value) {
		Node newNode = new Node();
		newNode.value = value;
		
		// If queue is empty, then new node is front and rear both
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		
		// Add the new node at the end of queue and change rear 
		else {
			tail.next = newNode;
			newNode.next = null;
			tail = newNode;
		}
		
		
	}
	
	//get the first element in the list and remove it
	public void dequeue () {
		if (head == null) { 
			System.out.println("Empty queue");
			return; 
		}
		
		head = head.next;
		
		if (head == null) tail = null;
	}
	
	public void display() {
		if (head == null) System.out.println("Empty Queue");
		else {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.value + " <-- ");
				temp = temp.next;
			}
			System.out.print("null");
		}
	}
	
	public static void main (String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.display();
		
		queue.enqueue(1);
		queue.display();
		System.out.println();
		queue.dequeue();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.display();
		System.out.println();
		
		queue.dequeue();
		queue.display();
		System.out.println();
		queue.dequeue();
		queue.display();
		System.out.println();
		queue.dequeue();
		queue.display();
		
	}
	
}
