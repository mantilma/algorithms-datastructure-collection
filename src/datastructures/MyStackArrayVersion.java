package datastructures;

import java.util.ArrayList;

public class MyStackArrayVersion<T> {
	private ArrayList<T> data = new ArrayList<>();
	
	public void pop () {
		if (data.size() == 0) {
			System.out.println("Empty stack");
			return;
		}
		
		data.remove(data.size()-1);
		
	}
	
	public void push (T value) {
		data.add(value);
	}
	
	public T peek () throws Exception {
		if (data.size() == 0) throw new Exception("Empty Stack");
		
		return data.get(data.size() - 1);
	}
	
	public void display() {
		System.out.println(data);
	}
	
	public static void main(String[] args) {
		MyStackArrayVersion<Integer> stack = new MyStackArrayVersion<Integer>();
		stack.display();
		stack.pop();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.display();
		
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		
	}
}
