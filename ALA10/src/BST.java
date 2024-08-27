
import java.util.Iterator;

public class BST <E extends Comparable<E>> implements Tree<E> {
	private TreeNode<E> root;
	private int size;
	
	private class TreeNode<E>{
		E value;
		TreeNode<E> left;
		TreeNode<E> right;
		TreeNode(E item){
			value = item;
			left = right = null;
		}
	}
	BST(){ root = null; size = 0; }

	BST(E[] dataArray){
		for(int i=0; i<dataArray.length; i++)
			insert(dataArray[i]);
	}

    public int size() { return size; }

	public boolean isEmpty() { return (size == 0); }

	public void clear() { root = null; }
	
	// definition of search()
	public boolean search(E item) {
		TreeNode<E> current = root;
		while (current != null) {
			if( item.compareTo(current.value) < 0)
				current = current.left;
			else if (item.compareTo(current.value)> 0)
				current = current.right;
			else // equals
				return true;
		}
		return false;
	}
	// definition of insert()
	public boolean insert(E item) {
		if (root == null) // first node to be inserted
			root = new TreeNode<>(item);
		else {
			TreeNode<E> parent, current;
			parent = null; current = root;
			while (current != null) {
	          parent = current;
				if(item.compareTo(current.value) < 0) {
					current = current.left; }
				else if (item.compareTo(current.value) > 0) {
					current = current.right; }
				else
					return false; // duplicates are not allowed
			}
			if (item.compareTo(parent.value)< 0)
				parent.left = new TreeNode<>(item);
			else
				parent.right = new TreeNode<>(item);
		}
		size++; 
		return true; 
	}
		
	// definition of delete()
	public boolean delete(E item) {
		TreeNode<E> parent, current;
		parent = null; current = root;
	    // Find item first
		while (current != null) {
	       parent = current;
	       if (item.compareTo(current.value) < 0) {
				current = current.left;
	       }
	       else if (item.compareTo(current.value) > 0) {
				current = current.right;
	       }
	       else
				break; // item found
		}
		if (current == null) // item not in the tree
			return false;
	    // Case 1: node found and has no left child
		if(current.left == null){ // No left child
			if (parent == null) // delete root
				root = current.right;
			else {// modify link from parent to current’s child
				if (item.compareTo(parent.value) < 0 )
					parent.left = current.right;
				else
					parent.right = current.right;
					
			}		
		 }
		else { //Case 2: current has a left child
			TreeNode<E> rightMostParent = current;
			TreeNode<E> rightMost = current.left;
			while (rightMost.right != null) { // going right
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			current.value = rightMost.value;
			//delete rigthMost node
			if (rightMostParent.right == rightMost)
				rightMostParent.right = rightMost.left;
			else
				rightMostParent.left = rightMost.left;
		}
		size--;
		return true;
	}
	// definition of inorder()
	public void inorder() {
		inorder(root);
	}
	// definition of recursive helper method inorder(TreeNode<E>))
	private void inorder(TreeNode<E> node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}
	// definition of preorder()
	public void preorder() {
		preorder(root);
	}
	// definition of recursive helper method preorder(TreeNode<E>))
	private void preorder(TreeNode<E> node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	// definition of postorder()
	public void postorder() {
		postorder(root);
	}
	// definition of recursive helper method postorder(TreeNode<E>))
	private void postorder(TreeNode<E> node)   
	{
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");	
		}
	}
	// definition of the method inherited from Collection with no default definition in Tree	
	public Iterator<E> iterator(){
			 return new InOrderIterator();
	}
	// class InOrderIterator for BST iterators 
	// creates an ArrayList that holds the nodes of the tree using inorder traversal
	private class InOrderIterator implements Iterator<E>{
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0;
		public InOrderIterator() {
			inorder();
		}
		private void inorder() {
			inorder(root);
		}
		private void inorder(TreeNode<E> root) {
			if(root == null)
				return;
			inorder(root.left);
			list.add(root.value);
			inorder(root.right);
		}
		public boolean hasNext() {
			return (current < list.size());
		}
		public E next() {
			return list.get(current++);
		}
		public void remove() {
			if(current == 0) // next() not called yet
				throw new IllegalStateException();		      
			delete(list.get(--current));
			list.clear();  
			inorder(); //rebuild the list
		}
	}
	
	public int searchComparisons(E item){
        int searches = 0;
        TreeNode<E> current = root;
        while (current != null) {
                searches++;
                if(item.compareTo(current.value) < 0){
                        current = current.left;
                }else if (item.compareTo(current.value)> 0){
                        current = current.right;
                }else
                    return searches;
        }
        return searches;
	}
	
}

