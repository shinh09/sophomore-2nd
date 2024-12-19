public class HW8TestCases {
	public static void main(String[] args) {
		 HW8 solution = new HW8();
	        String s1 = "anagram";
	        String t1 = "nagaram";
	        System.out.println("true: "+ solution.isAnagram(s1, t1)); // true
	        
	        String s2 = "hello";
	        String t2 = "lheho";
	        System.out.println("false: "+ solution.isAnagram(s2, t2)); // true

	        String s3 = "rat";
	        String t3 = "car";
	        System.out.println("false: "+ solution.isAnagram(s3, t3)); // false

	        String s4 = "aaaaabbbbbcccccdddddeeeee";
	        String t4 = "eeeeedddddcccccbbbbbaaaaa";
	        System.out.println("true: "+ solution.isAnagram(s4, t4)); // true

	        String s5 = "aaaaabbbbbcccccdddddeeeee";
	        String t5 = "eeeeedddddcccccbbbbbaaaab";
	        System.out.println("false: "+ solution.isAnagram(s5, t5)); // false	
	 }
}
