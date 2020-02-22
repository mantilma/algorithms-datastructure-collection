package datastructures;

public class MyBinarySearchTree {
	private class Node {
		Node left;
		Node right;
		Integer value;
	}
	
	private Node root;
	
	public void insert (Integer value) {
		Node newNode = new Node();
		newNode.value = value;
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		Node temp = root;	
		while (true) {
			if (temp.value.equals(value)) {
				System.out.println("No duplicate vertex allowed");
				return;
			}
			else if(temp.value value ) {
				
			}
		}
		
		
	}
}
