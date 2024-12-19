public class MyList {
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 6, 7, 9, 11, 13, 17, 21};
		System.out.println(binarySearch(13, a, 0, a.length-1));	
	}
	public static int binarySearch(int x, int[] a, int l, int r) {
		if(l>r) return -1;
		int m=(l+r)/2;
		if(a[m]<x) return binarySearch(x, a, m+1, r);
		else if(a[m]>x) return binarySearch(x, a, l, m-1);
		else return m;
	}
}
