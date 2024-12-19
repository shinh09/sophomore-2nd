public class QueueTest {
	public static void main(String[] args) {
		QueueInterface<String> crate = new ArrayQueue<>(3);
		System.out.println(crate.toString());
		crate.enqueue("Apple");
		System.out.println(crate.toString());
		crate.enqueue("Orange");
		System.out.println(crate.toString());
		crate.enqueue("Kiwi");
		System.out.println(crate.toString());
		System.out.println("dequeue: "+ crate.dequeue());
		System.out.println("size: "+ crate.size()+", getFront: "+ crate.getFront());
		crate.enqueue("Paprika");
		System.out.println(crate.toString());
		crate.enqueue("Peach");
		System.out.println(crate.toString());
	}
}
