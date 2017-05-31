package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import linked.RemoveDuplicatesfromSortedList.ListNode;

public class FindAllAnagramsinaString {

	public boolean isAnagram(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for(int i=0;i<t.length();i++){
			if(map.containsKey(t.charAt(i))){
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
				if(map.get(t.charAt(i)) == 0)
					map.remove(t.charAt(i));				
			}else {
				return false;
			}			
		}
		if(map.size() == 0)
			return true;
		else {
			return false;
		}
    }	
	
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
        	return list;
        Map<Character , Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<p.length();i++){
        	map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int start = 0 , end = 0 , counter = map.size();
        while(end < s.length()){
        	if(map.containsKey(s.charAt(end))){
        		map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
        		if(map.get(s.charAt(end)) == 0)
        			counter --;        		
        	}
        	end ++;
        	while(counter == 0){
        		if(end - start == p.length()){
        			list.add(start);
        		}
        		if(map.containsKey(s.charAt(start))){
        			map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
        			if(map.get(s.charAt(start)) > 0){
        				counter ++;
        			}
        		}        		
        		start ++;
        	}
        }
        return list;
    }
	
	public static void main(String[] args) {
		System.out.println(findAnagrams("abab", "ab").toString());
	}
}
