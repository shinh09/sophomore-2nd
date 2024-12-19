public class LinkedTest {
	public static void main(String[] args) {
		LinkedTree<Character> exTree = new LinkedTree<>();
		System.out.println("Is the tree empty? "+ exTree.isEmpty());
		LinkedTree<Character> minus 
			= new LinkedTree<>('-', new LinkedTree<Character>('1'), new LinkedTree<Character>('2'));
		LinkedTree<Character> five = new LinkedTree<Character>('5');
		LinkedTree<Character> times = new LinkedTree<Character>('*', minus, five);
		exTree.setRootData('+');
		exTree.setLeftChild(new LinkedTree<Character>('3'));
		exTree.setRightChild(times);
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
