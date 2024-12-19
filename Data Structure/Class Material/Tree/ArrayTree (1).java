import java.util.*;

public class ArrayTree<T> implements TreeInterface<T> {
	private T[] item;
	private int size;
	private int lastIndex;
	private boolean integrityOK;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayTree() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	public ArrayTree(int maxNode) {
		// the cast is safe because the new array contains null entries
		integrityOK = false;
		if(maxNode < MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempTree = (T[]) new Object[maxNode];
			size = 0;
			lastIndex = 0;
			item= tempTree;
			integrityOK = true;
		} else
			throw new IllegalStateException("Attempt to create a tree whose "
					+ "capacity exceeds allowed maximum.");				
	}
	public int setRootData(T data) {		
		return addNode(1, data);
	}
	public int addLeftChild(int parentIndex, T data) {
		return addNode(parentIndex*2, data);
	}
	public int addRightChild(int parentIndex, T data) {
		return addNode(parentIndex*2+1, data);
	}
	public T getRootData() {
		checkIntegrity();
		T result = item[1];
		return result;
	}
	public int getHeight() {
		return (int)(Math.log(lastIndex)/Math.log(2.));
	}
	public int size() {
		return size;
	}
	public String toString() {
		checkIntegrity();
		return Arrays.toString(item);
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		checkIntegrity();
		@SuppressWarnings("unchecked")
		T[] tempTree = (T[]) new Object[item.length];
		size = 0;
		lastIndex = 0;
		item = tempTree;
	}
	private void checkIntegrity() {
		if(!integrityOK) throw new SecurityException("ArrayBag object is corrupt");
	}
	private int addNode(int index, T data) {
		checkIntegrity();
		if(index < item.length) {
			if(item[index]==null)size++;
			item[index] = data;
			if(index>lastIndex) lastIndex = index;
		} else {
			index=-1;
			System.err.println(data+" cannot be added to "+(index*2)+" becase of the array size");
		}
		return index;
	} 
	private int getLeftIndex(int index) {
		checkIntegrity();
		int i = index*2;
		if(i>lastIndex || item[i] == null) return -1;
		else return i;
	}
	private int getRightIndex(int index) {
		checkIntegrity();
		int i = index*2+1;
		if(i>lastIndex || item[i] == null) return -1;
		else return i;
	}
	public String bfs() {
		String s="";
		for(int i = 1 ; i <= lastIndex ; i++)
			if(item[i]!=null) s+= item[i] + " ";
		return s;
	}
	public String preorder() {
		return preorder(1);
	}
	private String preorder(int i) {
		String s = "";
		int left = getLeftIndex(i);
		int right = getRightIndex(i);
		
		s += item[i] +" ";
		if(left>0) s += preorder(left);
		if(right>0) s += preorder(right);
		return s;
	}
	public String inorder() {
		return inorder(1);
	}
	private String inorder(int i) {
		String s = "";
		int left = getLeftIndex(i);
		int right = getRightIndex(i);
		if(left>0) s += inorder(left);
		s += item[i] +" ";
		if(right>0) s += inorder(right);
		return s;
	}
	public String postorder() {
		return postorder(1);
	}
	private String postorder(int i) {
		String s = "";
		int left = getLeftIndex(i);
		int right = getRightIndex(i);
		if(left>0) s += postorder(left);
		if(right>0) s += postorder(right);
		s += item[i] +" ";
		return s;
	}
}
