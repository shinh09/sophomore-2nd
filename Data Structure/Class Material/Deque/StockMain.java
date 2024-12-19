public class StockMain {
	public static void main(String[] args) {
		StockLedger book = new StockLedger();
		book.buy(6,45);
		book.buy(6,75);
		System.out.println("My capital gain is: "+book.sell(9, 65));
	}
}
