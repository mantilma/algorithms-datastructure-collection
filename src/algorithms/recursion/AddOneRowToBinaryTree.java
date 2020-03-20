package algorithms.recursion;

/*
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. 
 * The root node is at depth 1. 
 * 
 * Input: 
 * A binary tree as following:
 *     4
 *    /   
 *   2    
 *  / \   
 * 3   1    
 *
 * v = 1
 *
 * d = 3
 *
 * Output: 
 *       4
 *      /   
 *     2
 *    / \    
 *   1   1
 *  /     \  
 * 3       1
 * 
 */
public class AddOneRowToBinaryTree {
	//member inner class
	private class BinaryTree {
		int val;
		BinaryTree left;
		BinaryTree right;
		BinaryTree(int x) { val = x; }
	}
	
	public BinaryTree addOneRow(BinaryTree root, int val, int depth) {
        if (depth == 1) {
        	BinaryTree n = new BinaryTree(val);
            n.left = root;
            return n;
        }
        insert(root, val, depth, 1);
        return root;
    }
	
	public void insert(BinaryTree node, int val, int depth, int currentDepth) {
        if (node == null) return;
        
        if (currentDepth == depth - 1) {
        	BinaryTree n = new BinaryTree(val);
            n.left = node.left;
            node.left = n;
            n = new BinaryTree(val);
            n.right = node.right;
            node.right = n;
            return;
            /*
             * potevo anche fare, occhi all'utilizzo dei puntatori lato (prima dell'= e gli oggeti veri e propri):
             * BinaryTree t = node.left;
             * node.left = new BinaryTree(val);
             * node.left.left = t;
             * t = node.right;
             * node.right = new BinaryTree(val);
             * node.right.right = t;
             */
        }
        
        else {
            insert(node.left, val, depth, currentDepth + 1);
            insert(node.right, val, depth, currentDepth + 1);
        }
    }
	
	public void printBinaryTree(BinaryTree root) {
		if (root == null) { return; }
		System.out.println(root.val);
		printBinaryTree(root.left);
		printBinaryTree(root.right);
	}
	
	public static void main(String[] args) {
		AddOneRowToBinaryTree outer = new AddOneRowToBinaryTree();
		AddOneRowToBinaryTree.BinaryTree bt1 = outer.new BinaryTree(4);
		AddOneRowToBinaryTree.BinaryTree bt2 = outer.new BinaryTree(2);
		AddOneRowToBinaryTree.BinaryTree bt3 = outer.new BinaryTree(3);
		AddOneRowToBinaryTree.BinaryTree bt4 = outer.new BinaryTree(1);
				
		bt1.left = bt2;
		bt2.left = bt3;
		bt2.right = bt4;
		
		outer.printBinaryTree(bt1);
		
		outer.addOneRow(bt1, 1, 3);
		outer.printBinaryTree(bt1);
		
	}
}
