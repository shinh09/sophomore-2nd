public class Recursion {
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 7, 8, 10, 12, 15, 17};
		System.out.println(bs(12, a, 0, a.length-1));
	}
	public static int bs(int x, int[]a, int l, int r) {
		if(l > r) return -1;
		int m = (l+r)/2;
		if(a[m]== x) return m;
		else if (a[m]< x) return bs(x, a, m+1, r);
		else return bs(x, a, l, m-1);
	}
}
