import java.util.*;
/**
 * A class of stacks whose entries are stored in an array
 * @author jahee
 *
 * @param <T>
 */
public class ArrayStack<T> implements StackInterface<T> {
	private T[] item;	// array of stack entries
	private int top;	// index of the top entry(the number of entries in a stack-1)
	private boolean integrityOK;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayStack(int initialCapacity) {
		integrityOK = false;
		if(initialCapacity < MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempItem = (T[]) new Object[initialCapacity];
			item = tempItem;
			top = -1;
			integrityOK=true;
		} else
			throw new IllegalStateException("Attempt to create a stack whose "
					+ "capacity exceeds allowed maximum.");
	}
	public void push(T newEntry) {
		checkIntegrity();
		ensureCapacity();
		item[++top]=newEntry;
	}
	public T pop() {		
		if(isEmpty()) return null;
		else {
			T result = item[top];
			item[top] = null;
			top--;
			return result;
		}
	}
	public T peek() {
		if(isEmpty()) return null;
		else return item[top];
	}
	public boolean isEmpty() {
		return top<0;
	}
	public void clear() {
		@SuppressWarnings("unchecked")
		T[] tempItem = (T[]) new Object[item.length];
		item = tempItem;
		top = -1;
	}
	public int size() {
		return top+1;
	}
	private boolean isFull() {
		return top >= item.length-1;
	}
	private void checkIntegrity() {
		if(!integrityOK) throw new SecurityException("ArrayBag object is corrupt");
	}
	private void ensureCapacity() {
		if(top == item.length -1) {
			int newLength = 2*item.length;
			if(newLength < MAX_CAPACITY) {
				@SuppressWarnings("unchecked")
				T[] tempItem = (T[]) new Object[newLength];
				item= Arrays.copyOf(item, newLength);
			} else
				throw new IllegalStateException("Attempt to increse the size of a stack whose "
						+ "capacity exceeds allowed maximum.");
		}
	}
	public String toString() {
		String s = "ArrayStack ["+(top + 1)+"]: " ;
		for(int i = 0 ; i <= top ; i++)
			s += item[i] +"\t";
		return s;
	}

}
