package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();        
        for(int i=0;i<nums1.length;i++){
        	if(!set.contains(nums1[i])){
        		set.add(nums1[i]);
        	}
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for(int i=0;i<nums2.length;i++){
        	if(set.contains(nums2[i]) && !set2.contains(nums2[i])){
        		set2.add(nums2[i]);
        	}
        }
        int[] ansarr = new int[set2.size()];
        Iterator<Integer> iterator = set2.iterator();
        int i=0;
        while(iterator.hasNext()){
        	ansarr[i] = iterator.next();
        	i++;
        }
        return ansarr;
    }
	
	public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums1.length;i++){
        	map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<nums2.length;i++){
        	if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
        		ans.add(nums2[i]);
        		map.put(nums2[i], map.get(nums2[i]) - 1);
        	}
        }
        int[] ansarr = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
        	ansarr[i] = ans.get(i);
        }
        return ansarr;
    }
}















