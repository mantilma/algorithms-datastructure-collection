package exercises;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.



Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.*/

public class MinStack {

	private class Node {
		int data;
		int min;
		Node next;
	}

	private Node head;
	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		Node newNode = new Node();
		newNode.data = x;

		if (head == null) {
			head = newNode;
			newNode.min = x;
		}

		else {
			newNode.min = x < head.min ? x : head.min;
			newNode.next = head;
			head = newNode;
		}
	}

	public void pop() {
		if (head!= null) 
			head = head.next;
	}

	public int top() {
		if (head == null) return -1;
		return head.data;
	}

	public int getMin() {
		if (head == null) return -1;
		return head.min;
	}


}
