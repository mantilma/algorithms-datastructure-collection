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
			if (temp.value == value) {
				System.out.println("No duplicate vertex allowed");
				return;
			}
			else if(temp.value < value) {
				{
					if (temp.right == null) {
						temp.right = newNode;
						return;
					}
					
					temp = temp.right;
				}
			}
			else {
				if (temp.left == null) {
					temp.left = newNode;
					return;
				}
				temp = temp.left;
			}
		}		
	}
	
	public boolean lookup(Integer value) {
		
		Node temp = root;
		
		while (temp != null) {
			if (temp.value < value) {
				temp = temp.right;
				continue;
			}
			
			else if (temp.value > value) {
				temp = temp.left;
				continue;
			}
			
			else return true;
		}
		
		return false;
	}
	
	public boolean remove (Integer value) {
		if (root == null) return false;
		
		Node parent = null; // referenza al nodo padre necessaria per collegare il padre del nodo cancellato al figlio del nodo cancellato
		Node current = root;

		while (current != null) {
			if (value < current.value) {
				parent = current;
				current = current.left;
			}
			else if (value > current.value) {
				parent = current;
				current = current.right;
			}
			
			else //abbiamo trovato il nostro elemento. Ora dobbiamo estrarre l elemento min tra i max dei nodi figli. 
			{
				//1 allora se non ha figlio destro il nodo max è l'immediato figlio sinistro
				if (current.right == null) {
					if (parent == null) {
						//significa che l'elemento da cancellare era la root
						this.root = current.left;
					}
					
					else {
						if (current.value < parent.value) {
							//significa che sto eliminando un figlio sinistro del padre
							parent.left = current.left;
						}
						else if (current.value > parent.value) {
							//significa che sto eliminando un figlio destro del padre
							parent.right = current.right;
						}
					}
				}
				//2 right child which doesn't have a left child
				else if (current.right.left == null) {
					
				}
				//3 right child that has a left child
				else {
					
				}
				
				return true;
			}
				
		}
		
		return false;
		
	}
	
	//In-order means print (visit) the left branch, then the current node, and finally, the right branch
	public void displayInOrder (Node root) {
		if (root == null) { return; }
		
		displayInOrder(root.left);
		System.out.println(root.value);
		displayInOrder(root.right);
		
	}
	
	//In-order means print (visit) the current node, then its child. The root is always the fist node visited.
	public void displayPreOrder (Node root) {
		if (root == null) { return; }
		
		System.out.println(root.value);
		displayInOrder(root.left);
		displayInOrder(root.right);
		
	}
	
	//In-order means print (visit) the current node after its child. The root is always the last node visited.
	public void displayPostOrder (Node root) {
		if (root == null) { return; }
		
		System.out.println(root.value);
		displayInOrder(root.left);
		displayInOrder(root.right);
		
	}
	
	public static void main (String[] args) {
		MyBinarySearchTree tree = new MyBinarySearchTree();
		tree.insert(41);
		tree.insert(32);
		tree.insert(29);
		tree.insert(20);
		tree.insert(50);
		tree.insert(65);
		tree.insert(11);
		tree.insert(72);
		tree.insert(99);
		tree.insert(91);
		tree.displayInOrder(tree.root);
	}
	
}
