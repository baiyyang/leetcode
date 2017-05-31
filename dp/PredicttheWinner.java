package dp;

public class PredicttheWinner {

	public boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];
		int sum = 0;
		for(int i=0;i<n;i++){
			sum += nums[i];
		}
		for(int j=0;j<n;j++){
			int current = 0;
			for(int i=j;i>=0;i--){
				current += nums[i];
				if(i==j)
					dp[i][j] = nums[i];
				else {
					//dp[start][end]指的是从start到end玩家获得的最大值
					dp[i][j] = Math.max(current - dp[i][j-1], current - dp[i+1][j]);
				}
			}
		}
		return dp[0][n-1]*2 >= sum;
    }

}
