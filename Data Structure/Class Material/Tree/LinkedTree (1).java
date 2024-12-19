import java.util.*;
public class LinkedTree<T> implements TreeInterface<T> {
	private TreeNode<T> root=null;
	
	public LinkedTree() {
		root = null;
	}
	public LinkedTree(T x) {
		setRootData(x);
	}
	public LinkedTree(T x, LinkedTree<T> left, LinkedTree<T> right) {
		setRootData(x);
		root.left = setSubTree(left);
		TreeNode<T> temp = setSubTree(right);
		if(temp != null && temp == root.left ) {
			System.err.println("Both children cannot be the same");
			temp = null;
		}
		root.right = temp;
	}
	public T getRootData() {
		if(root==null) return null;
		return root.getData();
	}
	public int getHeight() {	
		if(root == null) {
			System.err.println("You try to know the height of an empty tree");
			return -1;
		}
		return root.getHeight();
	}
	public int size() {
		if(root == null) return 0;

		return root.getNumberOfNodes();
	}

	public boolean isEmpty() {
		return root==null;
	}

	public void clear() {
		root=null;
	}
	class TreeNode<T> {
		private T data;
		private TreeNode<T> left, right;
		TreeNode(T x){
			this(x, null, null);
		}
		TreeNode(T x, TreeNode<T> l, TreeNode<T> r){
			data = x; left = l; right = r;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public TreeNode<T> getLeftChild() {
			return left;
		}
		public void setLeftChild(TreeNode<T> left) {
			this.left = left;
		}
		public boolean hasLeftChild() {
			return left != null;
		}
		public TreeNode<T> getRightChild() {
			return right;
		}
		public void setRightChild(TreeNode<T> right) {
			this.right = right;
		}
		public boolean hasRightChild() {
			return right != null;
		}
		public boolean isLeaf() {
			return (left==null) && (right==null);
		}
		public int getNumberOfNodes() {
			if(isLeaf()) return 1;
			
			int num = 1;
			if(hasLeftChild()) num += left.getNumberOfNodes();
			if(hasRightChild()) num += right.getNumberOfNodes();
			return num;
		}
		public int getHeight() {
			if(isLeaf()) return 0;
			int leftHeight=0, rightHeight=0;
			if(hasLeftChild()) leftHeight = left.getHeight();
			if(hasRightChild()) rightHeight = right.getHeight();

			return Math.max(leftHeight, rightHeight)+1;
		}
		public String preorder() {
			String s = "";
			s+=data + " ";
			if(hasLeftChild())s+=left.preorder();
			if(hasRightChild())s+=right.preorder();
			return s;
		}
		public String inorder() {
			String s = "";
			if(hasLeftChild())s+=left.inorder();
			s+=data + " ";
			if(hasRightChild())s+=right.inorder();
			return s;
		}
		public String postorder() {
			String s = "";
			if(hasLeftChild())s+=left.postorder();
			if(hasRightChild())s+=right.postorder();
			s+=data + " ";
			return s;
		}
	}
	public void setRootData(T x) {
		if(root == null) root = new TreeNode<T>(x, null, null);
		root.setData(x);
	}
	public void setLeftChild(LinkedTree<T> t) {
		root.left = setSubTree(t);
	}
	public void setRightChild(LinkedTree<T> t) {
		root.right = setSubTree(t);
	}
	private TreeNode<T> setSubTree(LinkedTree<T> t) {
		if(t!=null && !t.isEmpty()) {
			return t.root;
		}
		return null;
	}
	public String bfs() {
		Queue<TreeNode<T>> q = new ArrayDeque();
		String s = "";
		if(!isEmpty()) {
			q.offer(root);
			for(TreeNode<T> node = q.poll() ; node!=null ; node = q.poll()) {
				s+=node.data + " ";
				if(node.hasLeftChild()) q.offer(node.left);
				if(node.hasRightChild()) q.offer(node.right);
			}
		}
		return s;
	}
	public String preorder() {		
		return root.preorder();
	}
	public String inorder() {
		return root.inorder();
	}
	public String postorder() {
		return root.postorder();
	}
}
