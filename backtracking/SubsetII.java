package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtracking(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
	
	public void backtracking(List<List<Integer>> ans , List<Integer> list , int[] nums , int start){
		ans.add(new ArrayList<Integer>(list));
		for(int i=start;i<nums.length;i++){
			if(i > start && nums[i] == nums[i-1])
				continue;
			list.add(nums[i]);
			backtracking(ans, list, nums, i+1);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,2};
		SubsetII subsets = new SubsetII();
		List<List<Integer>> ans = subsets.subsetsWithDup(nums);
		for(int i=0;i<ans.size();i++){
			System.out.println(Arrays.toString(ans.get(i).toArray()));
		}
	}
}
