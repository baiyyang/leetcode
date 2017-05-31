package baiyyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);		
        for(int i=0;i<nums.length-3;i++){        	        	 
        	 if(i==0||(i>0 && nums[i] != nums[i-1])){         		
        		 for(int j=i+1;j<nums.length-2;j++){
        			if(j==i+1 || (j>i+1 && nums[j] != nums[j-1])){
	             		int start = j+1;
	             		int end = nums.length -1;  		             		
	             		while(start < end){
	             			if(target - nums[i] - nums[j] - nums[start] - nums[end] == 0){
	             				ans.add(Arrays.asList(nums[i] , nums[j] , nums[start] , nums[end]));
	             				end--;
	             				while(start < end && nums[end] == nums[end + 1]) end--;
	             				start++;
	             				while(start < end && nums[start] == nums[start - 1]) start++;
	             			}
	             			else if(target - nums[i] - nums[j] - nums[start] - nums[end] > 0) {
								start++;
							}
	             			else {
								end--;
							}
	             		}	             		
	             	}             
        		 }	        		    	        
        	 }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		for(List<Integer> array : fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9)){
			System.out.println(array.toString());
		}
	}

}
