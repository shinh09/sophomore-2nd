public class Hanoi {
	public static void main(String[] args) {
		Hanoi tower = new Hanoi();
		tower.hanoi(3, "A", "C", "B");
	}
	/** solve the tower of Hanoi puzzle
	 * 
	 * @param num the number of disks
	 * @param source The source peg. You should move all disks from the source peg to target peg
	 * @param target The target peg. You should move all disks from the source peg to target peg
	 * @param spare The spare peg. You can use this peg for storing an unnecessary disks
	 */
	public void hanoi(int num, String source, String target, String spare) {
		// base case
		if(num == 1)
			System.out.println("Move one disk from " + source + " to "+ target);
		else {
			hanoi(num-1, source, spare, target);
			System.out.println("Move one disk from " + source + " to "+ target);
			hanoi(num-1, spare, target, source);
		}
	}
}
