package algorithms.search;

import java.util.ArrayDeque;
import java.util.Queue;

/* Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. 
 * It starts at the tree root and explores the neighbor nodes first, before moving to the next level neighbors.
 */
public class BFSInBinaryTree {
	//member inner class
	private static class BinaryTree {
		int val;
		BinaryTree left;
		BinaryTree right;
		BinaryTree(int x) { val = x; }
	}
	
	public void BFSIterative (BinaryTree root) {
		Queue<BinaryTree> queue = new ArrayDeque<BFSInBinaryTree.BinaryTree>();
		if (root == null)
			return;
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTree element = queue.remove();
			System.out.println(element.val + " ");
			if (element.left != null) {
				queue.add(element.left);
			}
			if (element.right != null) {
				queue.add(element.right);
			}
		}
	}
	
	public static void main (String[] args) {
		BinaryTree root = new BinaryTree(5);
		root.left = new BinaryTree(10);
		root.right = new BinaryTree(15);
		root.left.left = new BinaryTree(20);
		root.left.right = new BinaryTree(25);
		root.right.left = new BinaryTree(30);
		root.right.right = new BinaryTree(35);
		
		System.out.println("Breadth First Search : ");
		BFSInBinaryTree i = new BFSInBinaryTree();
		i.BFSIterative(root);
	}
}
