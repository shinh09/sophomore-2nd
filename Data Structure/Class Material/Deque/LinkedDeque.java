public class LinkedDeque<T> implements DequeInterface<T> {
	private Node first, last;
	private int size;
	public LinkedDeque() {
		clear();
	}
	public void addToFront(T newEntry) {
		if(isEmpty()) first = last = new Node(newEntry, null, first);
		else first = first.prev = new Node(newEntry, null, first);
		size++;
	}
	public void addToBack(T newEntry) {
		if(isEmpty()) last = first = new Node(newEntry, last, null);
		else last = last.next = new Node(newEntry, last, null);
		size ++;
	}
	public T removeFront() {
		T result = getFront();
		if (result == null) return null;
		size --;
		first = first.next;
		if(first == null) last = null;
		else first.prev = null;
		return result;
	}
	public T removeBack() {
		T result = getBack();
		if (result == null) return null;
		size --;
		last = last.prev;
		if(last == null) first = null;
		else last.next = null;
		return result;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void clear() {
		first = last = null;
		size = 0;
	}
	public String toString() {
		String s = "Deque["+size+"]:";
		if(size == 0) s+= null;
		else for(Node p = first; p != null ; p = p.next)
			s+=p.data+" ";
		return s;
	}
	public String reverseString() {
		String s = "Reverse Deque["+size+"]:";
		if(size == 0) s+= null;
		else for(Node p = last; p != null ; p = p.prev)
			s+=p.data+" ";
		return s;
	}

	private class Node {
		private T data;
		private Node prev, next;
		private Node(T d, Node p, Node n) {
			data = d; prev = p; next = n;
		}
	}
	public T getFront() {
		if(first == null) return null;
		T result = first.data;
		return result;
	}
	public T getBack() {
		if(last == null) return null;
		T result = last.data;
		return result;
	}
}
