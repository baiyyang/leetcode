package dp;

import java.util.HashMap;
import java.util.Map;

public class RangeSumQuery_Immutable {

	static class NumArray{
		
		public int[] nums;
		public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		public NumArray(int[] nums){
			this.nums = nums;
			start();
		}
		
		public int sumRange(int i, int j) {
	        if(i==0)
	        	return map.get(j);
	        else {
				return map.get(j) - map.get(i-1);
			}
	    }
		
		public void start(){
			int sum = 0;
			for(int i=0;i<nums.length;i++){
				sum += nums[i];
				map.put(i, sum);				
			}
		}
		
		public static void main(String[] args) {
			int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
			NumArray array = new NumArray(nums);	
			System.out.println(array.sumRange(0, 2));
		}
	}
	
}
