public class BST<T extends Comparable> extends LinkedTree<T> {
	public BST() {
		super();
	}
	public BST(T x) {
		super(x);
	}
	public boolean insert(T x) {
		boolean result = true;
		if(isEmpty()) super.setRootData(x); // case 1: The Tree is EmptySet the root to a new node containing the item
		else  result = insert(root, x); // case 2: The Tree is Not EmptyCall a recursive helper method to insert the item
		return result;
	}
	private boolean insert(LinkedTree.TreeNode<T> node, T x) {
		boolean result = true;
		int comp = x.compareTo(node.getData());
		if(comp == 0) result = false; // if a key is already included in the BST, it is false to insert
		else if (comp < 0) { // Case 2-1: If New data < key
			// Case 2-1-1: if the left is not empty, insert x in the left sub tree
			if(node.hasLeftChild()) result = insert(node.getLeftChild(), x);
			// Case 2-1-2: else if the left is empty, new data is a left child
			else node.setLeftChild(new TreeNode<T>(x));
		} else { // Case 2-2: If New data > key
			// Case 2-2-1: if the right is not empty, insert x in the right sub tree
			if(node.hasRightChild()) result = insert(node.getRightChild(), x);
			// Case 2-2-2: else if the right is empty, new data is a right child
			else node.setRightChild(new TreeNode<T>(x));
		}
 		return result;
	}
	public T contains(T x) {
		return find(getRootNode(), x);
	}
	private T find(TreeNode n, T x) {
		T result= null;
		if(n!=null) {
			T data = (T) n.getData();
			if(data.compareTo(x)==0) result = data;
			else if(data.compareTo(x)<0) result = find(n.getRightChild(), x);
			else result = find(n.getLeftChild(), x);
		}
		return result;
	}	 
	public T remove(T x) {
		NodeNData result = remove(root, x);
		root = result.node;
		return result.data;
	}
	// recursive helper method
	private NodeNData remove(LinkedTree.TreeNode<T> node, T x) {
		if(node==null) return new NodeNData(node, null);		// x is not in the tree
		NodeNData result = new NodeNData(node, node.getData());
		if(x.compareTo(node.getData())<0) {
			result = remove(node.getLeftChild(), x);
			node.setLeftChild(result.node); // for the case when child is changed 
			result.node = node;	// parent'value is not changed
		}
		else if(x.compareTo(node.getData())>0) {
			result = remove(node.getRightChild(), x);
			node.setRightChild(result.node);// for the case when child is changed 
			result.node = node; // parent'value is not changed
		}
		else {
			if(!node.hasLeftChild()) {
				result.node=node.getRightChild(); // case 1 or case 3, change parent's value
			}
			else if(!node.hasRightChild()) {
				result.node = node.getLeftChild();	// case 4, change parent's value
			} else { // case 2
				T temp = findMax(node.getLeftChild());
				node.setData(temp);
				node.setLeftChild(remove(node.getLeftChild(),temp).node);
			}
		}		
		return result;
	}
	public T findMax(LinkedTree.TreeNode<T> node) {
		if(node.hasRightChild()) return findMax(node.getRightChild());
		else return (T) node.getData();
	}
	// return type of remove method
	private class NodeNData{
		LinkedTree.TreeNode<T> node;	// node address for changing parent's value
		T data;	// value for returning to the client
		private NodeNData(LinkedTree.TreeNode<T> n, T x) {
			node = n; data=x;
		}
	}
}
