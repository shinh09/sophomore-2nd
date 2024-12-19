public class Stock {
	private int price;
	private int share;
	public Stock(int cost, int number) {
		price = cost;
		share = number;
	}
	public int getCostPerShare() {
		return price;
	}
	public int getNumberOfShares() {
		return share;
	}

}
