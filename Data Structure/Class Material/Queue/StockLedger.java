import java.util.*;
import java.util.concurrent.*;
/** Records the purchase and sale of stocks, and provides the capital
gain or loss. */
public class StockLedger{
	private Queue<StockPurchase> ledger;
	public StockLedger()	{
		ledger = new ArrayBlockingQueue(100);
	}
	/** Records a stock purchase in this ledger.
	 * @param sharesBought the number of shares purchased
	 * @param pricePerShare the price per share */
	public void buy(int sharesBought, int pricePerShare)	{
		for (; sharesBought > 0; sharesBought--)		{
			ledger.offer(new StockPurchase(pricePerShare));
		} 
	} 
	/** Removes from this ledger any shares that were sold
	 * and computes the capital gain or loss.
	 * @param sharesSold the number of shares sold
	 * @param pricePerShare the price per share
	 * @return the capital gain (loss) */
	public double sell(int sharesSold, int pricePerShare) 	{
		int saleAmount = sharesSold * pricePerShare;
		int totalCost = 0;
		for (;sharesSold > 0;sharesSold--) 		{
			StockPurchase share = ledger.poll();
			int shareCost = share.getCostPerShare();
			totalCost = totalCost + shareCost;
		} // end while
		return saleAmount - totalCost; // gain or loss
	} // end sell
} // end StockLedger