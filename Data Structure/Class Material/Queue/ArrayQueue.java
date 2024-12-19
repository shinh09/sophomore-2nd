import java.util.Arrays;

public class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int first;
	private int last;
	private boolean integrityOK;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayQueue()	{
		this(DEFAULT_INITIAL_CAPACITY);
	} 
	public ArrayQueue(int initialCapacity)	{
	// the cast is safe because the new array contains null entries
		integrityOK = false;
		if(initialCapacity < MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[initialCapacity + 1];
			queue = tempQueue;
			first = 0;
			last = initialCapacity;
			integrityOK = true;
		} else
			throw new IllegalStateException("Attempt to create a queue whose "
					+ "capacity exceeds allowed maximum.");		
	} // end constructor
	public void enqueue(T newEntry) {
		checkIntegrity();
		ensureCapacity();
		last = (last + 1) % queue.length;
		queue[last] = newEntry;
	}
	public T dequeue() {
		checkIntegrity();
		if(isEmpty()) return null;
		else {
			T result = queue[first];
			queue[first]=null;
			first = (first+1)%queue.length;
			return result;
		}	
	}
	public T getFront() {
		checkIntegrity();
		if(isEmpty()) return null;
		else {
			T result = queue[first];
			return result;
		}
	}
	public boolean isEmpty() {
		checkIntegrity();
		return first == (last +1)%queue.length;
	}
	public void clear() {
		checkIntegrity();
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[queue.length];
		first = 0;
		last = queue.length;
		queue = tempQueue;
	}
	public int size() {
		return (last+queue.length+1-first)%queue.length;
	}
	public String toString() {
		return "Queue["+ size()+", " +first+", "+last+"]: "+ Arrays.toString(queue);
	}

	private void checkIntegrity() {
		if(!integrityOK) throw new SecurityException("ArrayBag object is corrupt");
	}
	private void ensureCapacity() {
		if(first == (last +2) % queue.length ) {
			T[] oldQ = queue;
			int newSize = 2*oldQ.length;
			integrityOK=false;
			if(newSize-1 < MAX_CAPACITY) {
				@SuppressWarnings("unchecked")
				T[] tempQueue = (T[]) new Object[newSize];
				queue = tempQueue;
				for(int i = 0 ; i < oldQ.length -1 ; i++) {
					queue[i]=oldQ[first];
					first = (first+1)%oldQ.length;
				}
				first = 0;
				last = oldQ.length -2;
				integrityOK = true;
			} else
				throw new IllegalStateException("Attempt to create a queue whose "
						+ "capacity exceeds allowed maximum.");		
		}
	}
}
