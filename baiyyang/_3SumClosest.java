package baiyyang;

import java.util.Arrays;

public class _3SumClosest {
	
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length;i++){        	
        	int start = i+1;
        	int end = nums.length - 1;
        	while(start < end){
        		if(nums[i] + nums[start] + nums[end] == target)
        			return target;
        		else if(nums[i] + nums[start] + nums[end] > target){					
					if(diff > Math.abs(nums[i] + nums[start] + nums[end] - target)){
						diff = Math.abs(nums[i] + nums[start] + nums[end] - target);
						ans = nums[i] + nums[start] + nums[end];
					}
					end--;
				}
        		else {					
					if(diff > Math.abs(nums[i] + nums[start] + nums[end]- target)){
						diff = Math.abs(nums[i] + nums[start] + nums[end] - target);
						ans = nums[i] + nums[start] + nums[end];
					}
					start++;
				}
        	}        	
        }
        return ans;
    }
	
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{1,1,0,1}, -100));
	}

}
