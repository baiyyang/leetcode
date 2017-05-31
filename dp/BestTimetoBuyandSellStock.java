package dp;

public class BestTimetoBuyandSellStock {

	 public int maxProfit(int[] prices) {
		 if(prices.length == 0)
			 return 0;
		 int max = 0;
		 int min = prices[0];
		 for(int i=1;i<prices.length;i++){
			 max = Math.max(max, prices[i] - min);
			 min = Math.min(min, prices[i]);
		 }
		 return max;
	 }
	 
	 public static void main(String[] args) {
		BestTimetoBuyandSellStock b = new BestTimetoBuyandSellStock();
		System.out.println(b.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}
}
