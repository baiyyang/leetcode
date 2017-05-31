package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }
	
	public void backtracking(List<List<Integer>> ans , List<Integer> list , int[] nums , int target , int start){
		if(target < 0)
			return;
		else if(target == 0)
			ans.add(new ArrayList<Integer>(list));
		else {
			for(int i=start;i<nums.length;i++){
				if(i > start && nums[i] == nums[i-1])
					continue;
				list.add(nums[i]);
				backtracking(ans, list, nums, target - nums[i], i+1);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII sum = new CombinationSumII();
		List<List<Integer>> ans = sum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
		for(List<Integer> list : ans){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}
}
