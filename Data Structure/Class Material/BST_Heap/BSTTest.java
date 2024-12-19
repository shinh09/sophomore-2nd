public class BSTTest {
	public static void main(String[] args) {
		BST<PhoneDirectory> tree = new BST<PhoneDirectory>();
		if(tree.isEmpty()) System.out.println("No number in my emergency phone address book");
		else System.out.println("I have "+tree.size()+" numbers");
		
		tree.insert(new PhoneDirectory("Korea", "119"));
		tree.insert(new PhoneDirectory("Southern California", "116"));
		tree.insert(new PhoneDirectory("EU", "112"));
		tree.insert(new PhoneDirectory("USA", "911"));
		tree.insert(new PhoneDirectory("Australia", "000"));	
		tree.insert(new PhoneDirectory("London", "999"));
		tree.insert(new PhoneDirectory("France", "17"));

		if(tree.isEmpty()) System.out.println("No number in my emergency phone address book");
		else System.out.println("I have "+tree.size()+" numbers");
		
		PhoneDirectory address = tree.contains(new PhoneDirectory("USA", ""));
		if(address!=null) System.out.println(address);
		else System.out.println("We cannot find emergency phone number in USA");
		address = tree.contains(new PhoneDirectory("Japan", ""));
		if(address!=null) System.out.println(address);
		else System.out.println("We cannot find emergency phone number in Japan");
		
		System.out.println("BFS: "+tree.bfs());
		System.out.println("pre-order traversal: "+tree.preorder());
		System.out.println("in-order traversal: "+tree.inorder());
		System.out.println("post-order traversal: "+tree.postorder());
		
		System.out.println("Removing USA: "+ tree.remove(new PhoneDirectory("USA", "")));
		System.out.println("Removing Southern California: "+ tree.remove(new PhoneDirectory("Southern California", "")));
		System.out.println("Removing Korea: "+ tree.remove(new PhoneDirectory("Korea", "")));
		System.out.println("After removing USA, Southern California, Korea");
		System.out.println("BFS: "+tree.bfs());
		System.out.println("pre-order traversal: "+tree.preorder());
		System.out.println("in-order traversal: "+tree.inorder());
		System.out.println("post-order traversal: "+tree.postorder());
	}
}
