package twopoints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K_diffPairsinanArray {
	
	public static int findPairs(int[] nums, int k) {
		int ans = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
        	for(int j=i+1;j<nums.length;j++){
        		if((i == 0 || nums[i] != nums[i-1]) && Math.abs(nums[i] - nums[j]) == k){
        			ans ++;
        			break;
        		}
        	}
        }
        return ans;
    }
	
	public static int findPairs1(int[] nums , int k){
		if(k < 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int ans = 0;
		for(int i=0;i<nums.length;i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			if(k == 0){
				if(entry.getValue() > 1)
					ans ++;
			}
			else{
				if(map.containsKey(entry.getKey() + k))
					ans ++;
			}
				
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		System.out.println(findPairs1(new int[]{1,2,3,4,5}, -1));
	}

}
