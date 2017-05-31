package baiyyang;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<String>();
    	backTracing(ans, "", 0, 0, n);
    	return ans;
    }
    
    public static void backTracing(List<String> ans , String s , int left , int right , int n){
    	if(s.length() == 2*n){
    		ans.add(s);
    	}    	
		if(left >= right && left < n){
			backTracing(ans, s+'(', left+1, right, n);
		}
		if(left >= right && right < n){
			backTracing(ans, s+')', left, right+1, n);
		}
		
    }
	
	public static void main(String[] args) {		
		for(String string : generateParenthesis(3)){
			System.out.println(string);
		}
	}
}
