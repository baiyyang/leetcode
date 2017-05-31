package dp;

public class BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {
		 int max = 0;
		 for(int i=0;i<prices.length-1;i++){
			 if(prices[i+1] > prices[i])
				 max += prices[i+1] - prices[i];
		 }
		 return max;
	 }	
	 
	 public static void main(String[] args) {
		BestTimetoBuyandSellStockII b = new BestTimetoBuyandSellStockII();
		System.out.println(b.maxProfit(new int[]{1,2, 4}));
	}
}
