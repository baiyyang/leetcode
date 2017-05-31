package baiyyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

	public static List<String> ans = new ArrayList<String>();
	public static Map<Integer, Character[]> map =new HashMap<Integer, Character[]>();	
	
    public static List<String> letterCombinations(String digits) {	
    	ans.clear();
    	if("".equals(digits)) return ans;
    	map.put(2, new Character[]{'a','b','c'});
    	map.put(3, new Character[]{'d','e','f'});
    	map.put(4, new Character[]{'g' , 'h' , 'i'});
    	map.put(5, new Character[]{'j' ,'k','l'});
    	map.put(6, new Character[]{'m' , 'n' , 'o'});
    	map.put(7, new Character[]{'p','q','r','s'});
    	map.put(8, new Character[]{'t','u','v'});
    	map.put(9, new Character[]{'w','x','y','z'});    	
        solve(digits , 0 ,digits.length() , "");        
        return ans;
    }
    
    public static void solve(String digits , int begin , int end ,String current){
    	if(begin == end){
    		ans.add(current);    		
    	}
    	else {    		
    		if(map.containsKey(digits.charAt(begin) - '0')){
    			Character[] v = map.get(digits.charAt(begin) - '0');
    			for(int j=0;j<v.length;j++){    				
    				solve(digits , begin+1 , end , current+v[j]);
    			}    		
        	}
		}
    	
    }
    
	public static void main(String[] args) {
		for(String string : letterCombinations("5")){
			System.out.println(string);
		}
	}
}
