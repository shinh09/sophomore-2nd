public class LinkedStack<T> implements StackInterface<T> {
	private Node<T> top;
	private int size;
	public LinkedStack() {
		top = null;
		size = 0;
	}
	public void push(T newEntry) {
		top = new Node(newEntry, top);
		size++;
	}
	public T pop() {
		T result = peek();
		if(top!=null) {
			top = top.next;
			size--;
		}
		return result;
	}
	public T peek() {
		T result = null;
		if(top!=null) result = top.data;
		return result;
	}
	public boolean isEmpty() {
		return top==null;
	}
	public void clear() {
		top = null;
		size = 0;
	}
	public int size() {
		return size;
	}
	public String toString() {
		String result = "LinkedStack [size=" + size + "]: ";
		if(top == null) result += null;
		else {
			for(Node<T> p  = top; p != null ; p = p.next) 
				result+= p.data + "\t";
		}
		return result;
	}
	private class Node<T> {
		private T data;
		private Node<T> next;
		private Node(T x, Node<T> n) {
			data = x; next = n;
		}
	}
}
