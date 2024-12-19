/**
 * An Interface for the ADT deque
 * @author jahee
 * @param <T> : the class type that a dequeue constrains
 */
public interface DequeInterface<T> {
	/** Add a new etnry to the front of this deque
	 * @param newEntry an Object to be added
	 */
	public void addToFront(T newEntry);
	/** Add a new etnry to the back of this deque
	 * @param newEntry an Object to be added
	 */
	public void addToBack(T newEntry);
	/**
	 * Removes and returns the front entry of this deque.
	 * @return the object at the front of the deque
	 */
	public T removeFront();
	/**
	 * Removes and returns the back entry of this deque.
	 * @return the object at the back of the deque
	 */
	public T removeBack();
	/**
	 * Retrieves the front entry of this deque.
	 * @return the object at the front of the deque
	 */
	public T getFront();
	/**
	 * Retrieves the back entry of this deque.
	 * @return the object at the back of the deque
	 */
	public T getBack();
	/**
	 * Detects whether this deque is empty
	 * @return true if the deque is empty. or false otherwise
	 */
	public boolean isEmpty();
	/**
	 * removes all entries from this deque
	 */
	public void clear();
}
