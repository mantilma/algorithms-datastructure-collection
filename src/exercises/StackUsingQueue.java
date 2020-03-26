package exercises;

import java.util.ArrayDeque;

public class StackUsingQueue {
	ArrayDeque<Integer> queue = new ArrayDeque<>();
	
	/** Push element x onto stack. */
    public void push(int x) {
        ArrayDeque<Integer> tmpQueue = new ArrayDeque<>();
        tmpQueue.add(x);
        while (!queue.isEmpty()) {
            tmpQueue.add(queue.remove());
        }
        queue = tmpQueue;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.element();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
