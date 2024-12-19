import java.util.*;
public class ToyStack {
	public static void main(String[] args) {
		StackInterface<String> toys = new ArrayStack<>(10);
		toys.push("Red YOYO");
		toys.push("Black COOKIE MAN");
		toys.push("Blue NINJA");
		System.out.println("peek: "+ toys.peek());
		System.out.println("size: "+ toys.size());
		System.out.println("pop: "+ toys.pop());
		toys.push("Yellow YOYO");
		System.out.println(toys.toString());		
	}
}