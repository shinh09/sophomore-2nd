import java.util.*;
import java.util.concurrent.*;
public class WaitingLine {
	private Queue<Customer> line;
	private int totalTimeWaited;
	private int numberServed;
	private int numberArrivals;
	public WaitingLine() {
		line = new ArrayBlockingQueue(10);
		reset();
	}
	/** Simulates a waiting line with one serving agent.
	@param duration the number of simulated minutes
	@param arrivalProbability a real number between 0 and 1, and the
	probability that a customer arrives at
	a given time
	@param maxTransactionTime the longest transaction time for a
	customer */
	public void simulate(int duration, double arrivalProbability,
			int maxTransactionTime)	{
		int transactionTimeLeft = 0;
		for (int clock = 0; clock < duration; clock++)		{
			if (Math.random() < arrivalProbability)			{
				numberArrivals++;
				int transactionTime = (int)(Math.random()
						* maxTransactionTime + 1);
				line.offer(new Customer(clock, transactionTime));
				System.out.println("Customer " + numberArrivals
						+ " enters line at time " + clock
						+ ". Transaction time is "
						+ transactionTime);
			} // end if
			if (transactionTimeLeft > 0)
				transactionTimeLeft--;
			else if (!line.isEmpty()){
				Customer nextCustomer = line.poll();
				if(nextCustomer != null) {
					transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
					int timeWaited = clock - nextCustomer.getArrivalTime();
					totalTimeWaited = totalTimeWaited + timeWaited;
					numberServed++;
					System.out.println("Customer "
							+ nextCustomer.getCustomerNumber()
							+ " begins service at time " + clock
							+ ". Time waiteSd is " + timeWaited);
				}
			} // end if
		} // end for
	} // end simulate
	/** Displays summary results of the simulation. */
	public void displayResults()	{
		System.out.println();
		System.out.println("Number served = " + numberServed);
		System.out.println("Total time waited = " + totalTimeWaited);
		double averageTimeWaited = ((double)totalTimeWaited) /numberServed;
		System.out.println("Average time waited = " + averageTimeWaited);
		int leftInLine = numberArrivals - numberServed;
		System.out.println("Number left in line = " + leftInLine);
	} 
	/** Initializes the simulation. */
	public final void reset() {
		line.clear();
		totalTimeWaited = 0;
		numberServed = 0;
		numberArrivals = 0;
	}

}
