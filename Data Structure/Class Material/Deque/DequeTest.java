public class DequeTest {
	public static void main(String[] args) {
		DequeInterface<String> crate = new LinkedDeque();
		crate.addToFront("Apple");
		crate.addToFront("Orange");
		crate.addToBack("Kiwi");
		System.out.println("getFront: "+crate.getFront());
		System.out.println("getBack: "+crate.getBack());
		System.out.println("after removing Front: "+crate.removeFront());
		System.out.println(crate.toString()+", "
				+((LinkedDeque)crate).reverseString());
		System.out.println("after removing Back: "+crate.removeBack());
		System.out.println(crate.toString()+", "
				+((LinkedDeque)crate).reverseString());
	}
}
