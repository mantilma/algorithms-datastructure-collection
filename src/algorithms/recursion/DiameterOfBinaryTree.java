package algorithms.recursion;

/*Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

         1
        / \
       2   3
      / \     
     4   5    

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. */

public class DiameterOfBinaryTree {
	int solution = 0;
	
	private class TreeNode {
		TreeNode left;
		TreeNode right;
	}
    
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return solution;
    }
    
    public int diameter (TreeNode node) {
        if (node == null) return 0;
        
        int l, r = 0;
        l = diameter(node.left);
        r = diameter(node.right);
        
        solution = Math.max(solution, l + r);
        
        return Math.max(l, r) + 1;
    }
}
