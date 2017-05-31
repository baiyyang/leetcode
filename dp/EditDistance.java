package dp;

public class EditDistance {

	public static int minDistance(String word1, String word2) {
		if((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)){
			return 0;
		}
        if(word1 == null || word1.length() == 0){
        	return word2.length();
        }
        if(word2 == null || word2.length() == 0){
        	return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i=0;i<word1.length() + 1;i++){
        	dp[i][0] = i;
        }
        for(int j=0;j<word2.length() + 1;j++){
        	dp[0][j] = j;
        }
        for(int i=0;i<word1.length();i++){
        	for(int j=0;j<word2.length();j++){
        		int flag = 1;
        		if(word1.charAt(i) == word2.charAt(j))
        			flag = 0;
        		dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1] + 1, dp[i+1][j] + 1), dp[i][j] + flag);
        	}
        }
        return dp[word1.length()][word2.length()];
    }
	
	public static void main(String[] args) {
		System.out.println(minDistance("ab", "bc"));
	}
}
