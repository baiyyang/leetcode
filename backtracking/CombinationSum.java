package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		//Arrays.sort(candidates);
		backtracking(ans, new ArrayList<Integer>(), candidates , target , 0);
		return ans;
    }
	
	public void backtracking(List<List<Integer>> ans , List<Integer> list , int[] nums , int target , int start) {
		if(target < 0)
			return;
		else if(target == 0)
			ans.add(new ArrayList<Integer>(list));
		else {
			for(int i=start;i<nums.length;i++){				
				list.add(nums[i]);
				backtracking(ans, list, nums, target - nums[i], i);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum sum = new CombinationSum();		
		List<List<Integer>> ans = sum.combinationSum(new int[]{2,3,6,7}, 7);
		for(List<Integer> list : ans){
			System.out.println(Arrays.toString(list.toArray()));
		}
		
	}
}
