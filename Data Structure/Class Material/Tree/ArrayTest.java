public class ArrayTest {
	public static void main(String[] args) {
		ArrayTree<Character> exTree = new ArrayTree<>(15);
		System.out.println("Is the tree empty? "+ exTree.isEmpty());
		int index = exTree.setRootData('+');
		exTree.addLeftChild(index, '3');
		index = exTree.addRightChild(index, '*');
		exTree.addRightChild(index, '5');
		index = exTree.addLeftChild(index, '-');
		exTree.addLeftChild(index, '1');
		exTree.addRightChild(index, '2');
		System.out.println("After adding, is the tree empty? "+ exTree.isEmpty());
		System.out.println("The current height is "+exTree.getHeight());
		System.out.println(exTree.getRootData()+"["+exTree.size()+"]: "+exTree.toString());
		System.out.println("BFS: "+exTree.bfs());
		System.out.println("pre-order traversal: "+exTree.preorder());
		System.out.println("in-order traversal: "+exTree.inorder());
		System.out.println("post-order traversal: "+exTree.postorder());
		exTree.clear();
		System.out.println("After clearing, is the tree empty? "+ exTree.isEmpty());
		if(!exTree.isEmpty()) System.out.println("The current height is "+exTree.getHeight());
		System.out.println(exTree.getRootData()+"["+exTree.size()+"]: "+exTree.toString());
	}
}
