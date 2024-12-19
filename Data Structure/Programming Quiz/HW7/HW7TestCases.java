public class HW7TestCases {
	public static void main(String[] args) {
		HW7 h = new HW7();
		int[][] tc = {
				{-1, 1, 2, 3, 4, 5, 6}, // valid min heap: true
				{-1, 1, 5, 2, 4, 3, 6}, // invalid min heap: false
				{-1}, // empty heap: true
				{1, 20, 18, 10, 9, 12, 6, 8}, // valid max heap: true
				{1, 1, 2, 3, 4, 5, 6}, // invalid max heap: false
		};
		boolean[] expected = {true, false, true, true, false};
		for(int i = 0 ; i < tc.length; i++)
			System.out.println(expected[i] + ": " + h.isHeap(tc[i]));
	}
}
