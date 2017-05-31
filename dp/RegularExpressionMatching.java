package dp;

public class RegularExpressionMatching {
	
	 public static boolean isMatch(String s, String p) {   
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		if(s.length() == 0 && p.length() == 0)
			return true;
		if(p.length() == 0)
			return false;
		dp[0][0] = true;
		//≥ı ºªØ£¨∆•≈‰0¥Œ
		for(int i=1;i<p.length();i+=2){
			if(p.charAt(i)=='*')
				dp[0][i+1] = dp[0][i-1];
		}
		for(int i=1;i<=s.length();i++){
			for(int j=1;j<=p.length();j++){
				if(p.charAt(j-1) != '*'){
					dp[i][j]=dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) == '.');
				}
				else {
					dp[i][j]=dp[i][j-2] || dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.');
				}
			}
		}
		return dp[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "b.*"));		
	}

}
