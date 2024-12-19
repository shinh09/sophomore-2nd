public class SimulationQueue {
	public static void main(String[] args) {
		WaitingLine customerLine = new WaitingLine();
		customerLine.simulate(10, 0.5, 3);
		customerLine.displayResults();
	}
}
