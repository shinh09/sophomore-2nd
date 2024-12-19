public interface TreeInterface<T> {
	public T getRootData();
	public int getHeight();
	public int size();
	public boolean isEmpty();
	public void clear();
	public String bfs();
	public String preorder();
	public String inorder();
	public String postorder();
}
