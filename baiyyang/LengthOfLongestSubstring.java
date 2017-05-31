package baiyyang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
	
	public static int solve(String s){
		int max = 0;
		int j = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i))){
				if(j < map.get(s.charAt(i)) + 1)
					j = map.get(s.charAt(i)) + 1;
			}
			map.put(s.charAt(i), i);
			if(max < i-j+1){
				max = i-j+1;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(""));
	}

}
