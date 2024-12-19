public class Recursion2 {
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 7, 8, 10, 12, 15, 17};
		System.out.println(bs(12, a, 0, a.length-1));
	}
	public static int bs(int x, int[]a, int l, int r) {
		int m;
		int newL=l, newR=r;

		do {
			if(newL > newR) return -1;
			m = (newL+newR)/2;
			if (a[m]< x) {
				newL = m+1;
			}
			else {
				newR = m-1;
			}
		}while(a[m]!= x);
		return m;
	}
}
