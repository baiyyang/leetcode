package baiyyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
        	int start = i+1;
        	int end = nums.length - 1;
        	int sum = 0-nums[i];
        	if(i==0 || (i>0 && nums[i] != nums[i-1])){
        		while(start < end){
        			if(nums[start]+nums[end] == sum){
        				ans.add(Arrays.asList(nums[i] , nums[start] , nums[end])); 
        				start++;
        				while( start < end && nums[start] == nums[start-1]) start++;
        				end--;
        				while(start < end && nums[end] == nums[end+1])  end--;
        			}
        			else if(nums[start]+nums[end] > sum){
        				end--;
        			}
        			else {
						start++;
					}
        		}
        	}
        }
        return ans;
    }

	public static void main(String[] args) {
		for(List<Integer> list :threeSum(new int[]{-2,0,0,2,2})){
			System.out.println(list);
		}
	}
}
