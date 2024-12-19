public class LinkedQueue<T> implements QueueInterface<T> {
	private Node first, last;
	private int size;
	public LinkedQueue() {
		first = last = null;
		size = 0;
	}
	public void enqueue(T newEntry) {
		if (isEmpty())	
			first = last = new Node(newEntry, null);
		else
			last = last.next = new Node(newEntry, null); 
		size++;		
	}
	public T dequeue() {
		if(isEmpty())	return null;
		T result = first.data;
		if(first == last) first = last = null;
		else first = first.next;
		size --;
		return result;
	}
	public T getFront() {		
		if(isEmpty())	return null;
		T result = first.data;
		return result;

	}
	public boolean isEmpty() {
		return size==0;
	}
	public void clear() {
		size = 0;
		first = last = null;
	}
	public int size() {
		return size;
	}
	public String toString() {
		if(first == null) return "[]";
		String s = "[";
		Node p = first;		
		for(; p.next != null ; p = p.next)
			s+= p.data +", ";
		if(p!=null) s+= p.data;
		s+="]";
		return s;
	}
	private class Node {
		private T data;
		private Node next;
		private Node(T x, Node n) {
			data = x; next = n;
		}
	}
}
