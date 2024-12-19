public class Customer {
	private int arrivalTime; // the time when the customer arrivals the ticket box
	private int transactionTime; // how long it takes for an agent to serve for the customer
	private int customerNumber;	// the customer ID
	private static int total=1;
	public Customer(int clock, int serviceTime) {
		customerNumber = total++;
		arrivalTime = clock;
		transactionTime = serviceTime;
	}
	/**
	 * @return the arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @return the transactionTime
	 */
	public int getTransactionTime() {
		return transactionTime;
	}
	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}
	
}
