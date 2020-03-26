package exercises;

import java.util.ArrayDeque;

/*
 * Java program to implement Queue using  
 * two stacks with costly enQueue()  
 */
public class QueueUsingStack {
	private ArrayDeque<Integer> stack = new ArrayDeque<>();
	
	public void Enqueue (int x) {
		ArrayDeque<Integer> tmpStack = new ArrayDeque<>();
		while (!stack.isEmpty()) {
			tmpStack.push(stack.pop());
		}
		tmpStack.push(x);
		while (!tmpStack.isEmpty()) {
			stack.push(tmpStack.pop());
		}
	}
	
	public int Dequeue () {
		return stack.pop();
	}
}
