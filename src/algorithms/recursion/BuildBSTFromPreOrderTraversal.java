package algorithms.recursion;

/*
 * Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
 */

public class BuildBSTFromPreOrderTraversal {
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);   
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) return null;
        
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for(i=start;i<=end;i++) {
        if(preorder[i] > node.val)
            break;
        }
        
        node.left = helper(preorder, start+1, i-1);
        node.right = helper(preorder, i, end);
        return node;
    }
}
