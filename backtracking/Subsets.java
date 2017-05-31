package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		//Arrays.sort(nums);
		backtrack(ans, new ArrayList<Integer>(), nums, 0);
		return ans;
    }
	
	public void backtrack(List<List<Integer>> ans , List<Integer> subset , int[] nums , int start){
		ans.add(new ArrayList<Integer>(subset));
		for(int i=start;i<nums.length;i++){
			subset.add(nums[i]);
			backtrack(ans, subset, nums, i+1);
			subset.remove(subset.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		Subsets subsets = new Subsets();
		List<List<Integer>> ans = subsets.subsets(nums);
		for(int i=0;i<ans.size();i++){
			System.out.println(Arrays.toString(ans.get(i).toArray()));
		}
	}
}
