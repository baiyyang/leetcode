package baiyyang;

public class LongestPalindromicSubstring {

	public static String solve(String s){
		String ans = "";
 		for(int i=0;i<s.length();i++){
 			if(ans.length() < subString(s, i, i).length()){
 				ans = subString(s, i, i);
 			}
 			if(i+1 < s.length() && ans.length() < subString(s, i, i+1).length()){
 				ans = subString(s, i, i+1);
 			}
 		}
 		return ans;
	}
	
	public static String subString(String s , int start , int end){
		if(s.charAt(start) != s.charAt(end)){
			return "";
		}
		while(start >= 0 && end < s.length()){
			if(s.charAt(start) == s.charAt(end)){
				start--;
				end++;
			}
			else {
				return s.substring(start + 1, end);
			}
		}
		if(start < 0 && end >= s.length()){
			return s;
		}
		else if (start < 0) {
			return s.substring(0 , end);
		}
		else {
			return s.substring(start + 1 , end);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solve("abaaa"));
	}
}
