import java.util.*;

class TreeNode<T extends Comparable> {
    T data;
    TreeNode left;
    TreeNode right;

    TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
  
    public String toString() {
    	String str = ""+data;
    	if(left != null) str = str.toString() + " left:  " + left.toString();
    	if(right!= null) str = str.toString() + " right: " + right.toString();
    	return str;
    }

	public static TreeNode constructTree(Integer[] integers) {
		TreeNode root = null;
		root = root.makeSubTree(integers, 0);
		return root;
	}
	private static TreeNode makeSubTree(Integer[] integers, int index) {
		if(index >= integers.length) return null;
		if(integers[index] == null) return null;
		TreeNode node = new TreeNode(integers[index]);
		if(2*index+1 < integers.length) node.left = makeSubTree(integers, 2*index+1);
		if(2*index+2 < integers.length) node.right = makeSubTree(integers, 2*index+2);
		return node;		
	}
}
