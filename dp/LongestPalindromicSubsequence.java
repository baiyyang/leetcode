package dp;

public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String s) {
		if(s == null || s.equals(""))
			return 0;
		char[] s1 = s.toCharArray();
		char[] s2 = new char[s.length()];
		for(int i=s.length()-1;i>=0;i--){
			s2[s.length() - i - 1] = s.charAt(i);
		}
		int[][] dp = new int[s.length() + 1][s.length() + 1];		
		for(int i=0;i<s.length();i++){
			for(int j=0;j<s.length();j++){
				if(s1[i] == s2[j]){
					dp[i+1][j+1] = dp[i][j] + 1;
				}else {
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
			}
		}
		return dp[s.length()][s.length()];
	}
}
