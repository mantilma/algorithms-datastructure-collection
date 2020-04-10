package datastructures;

//Java program to Implement a stack 
//using singly linked list
//The main Stack's characteristic is that insert and delete happens on the same side
public class MyStackListVersion<T> {
	
	private class Node {
		Node next;
		T data;
	}
	
	private Node head;
	
	public void push (T data) {
		Node newNode = new Node();
		newNode.next = head;
		newNode.data = data;
		head = newNode;
	}
	
	public void pop () {
		if (head == null) {
			System.out.println("Empty Stack");
			return;
		}
		head = head.next;
	}
	
	public T peek () throws Exception {
		if (head == null) throw new Exception("Empty Stack");
		return head.data;
	}
	
	public void display() {
		if (head == null) System.out.println("Empty Stack");
		else {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.data + " --> ");
				temp = temp.next;
			}
			System.out.print(" null");
		}
	}
	
	public static void main (String[] args) throws Exception {
		MyStackListVersion<Integer> stack = new MyStackListVersion<Integer>();
		stack.display();
		stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		System.out.println();
		stack.peek();
		stack.pop();
		stack.display();
		System.out.println();
		stack.peek();
		stack.pop();
		stack.display();
		System.out.println();
		stack.peek();
		stack.pop();
		stack.display();
		System.out.println();
		stack.peek();
		stack.pop();
		stack.display();
		
	}
	
}
