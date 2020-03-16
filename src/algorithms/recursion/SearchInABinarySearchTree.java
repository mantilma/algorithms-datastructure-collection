package algorithms.recursion;

/*
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2

You should return this subtree:

      2     
     / \   
    1   3

In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 */
public class SearchInABinarySearchTree {
	private static class BinarySearchTree {
		int val;
		BinarySearchTree left;
		BinarySearchTree right;
		BinarySearchTree(int x) { val = x; }
	}
	
	public BinarySearchTree searchBST(BinarySearchTree root, int val) {
        if (root == null) return null;
        
        if (root.val == val) return root;
        
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
	
	public static void main (String[] args) {
		BinarySearchTree bs1 = new BinarySearchTree(4);
		BinarySearchTree bs2 = new BinarySearchTree(2);
		BinarySearchTree bs3 = new BinarySearchTree(7);
		BinarySearchTree bs4 = new BinarySearchTree(1);
		BinarySearchTree bs5 = new BinarySearchTree(3);
		
		bs1.left = bs2;
		bs1.right = bs3;
		
		bs2.left = bs4;
		bs2.right = bs5;
		
		BinarySearchTree result = new SearchInABinarySearchTree().searchBST(bs1, 2);
		if (result == null) System.out.println("null");
		else System.out.println(result.val + " " 
				+ (result.left == null ? null : result.left.val) + " " 
				+ (result.right == null ? null : result.right.val));

		
	}
	
}
