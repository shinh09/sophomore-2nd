import java.util.*;
import java.util.concurrent.*;
/** Records the purchase and sale of stocks, 
 * and provides the capital gain or loss. */
public class StockLedger{
	private Deque<Stock> ledger;
	public StockLedger()	{
		ledger = new ArrayDeque<Stock>(100);
	}
	/** Records a stock purchase in this ledger.
	 * @param sharesBought the number of shares purchased
	 * @param pricePerShare the price per share */
	public void buy(int sharesBought, int pricePerShare)	{
		ledger.offer(new Stock(pricePerShare, sharesBought));
	} 
	/** Removes from this ledger any shares that were sold
	 * and computes the capital gain or loss.
	 * @param sharesSold the number of shares sold
	 * @param pricePerShare the price per share
	 * @return the capital gain (loss) */
	public double sell(int sharesSold, int pricePerShare) 	{
		int saleAmount = sharesSold * pricePerShare;
		int totalCost = 0;
		while(sharesSold > 0) 		{
			Stock transaction = ledger.removeFirst();
			int stockCost = transaction.getCostPerShare();
			int stockNumber = transaction.getNumberOfShares();
			if(stockNumber > sharesSold) {
				totalCost = totalCost + sharesSold*stockCost;
				ledger.addFirst(new Stock(stockCost, stockNumber - sharesSold));
			} else 
				totalCost = totalCost + stockCost*stockNumber;
			sharesSold = sharesSold - stockNumber;
		} // end while
		return saleAmount - totalCost; // gain or loss
	} // end sell
} // end StockLedger