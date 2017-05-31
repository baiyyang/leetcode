package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(ans, new ArrayList<Integer>(), nums, used);
        return ans;
    }
	
	public void backtracking(List<List<Integer>> ans , List<Integer> list , int[] nums , boolean[] used){
		if(list.size() == nums.length)
			ans.add(new ArrayList<Integer>(list));
		else {
			for(int i=0;i<nums.length;i++){
				if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1]))
					continue;
				used[i] = true;
				list.add(nums[i]);
				backtracking(ans, list, nums, used);
				used[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		PermutationsII permutations = new PermutationsII();
		List<List<Integer>> ans = permutations.permuteUnique(new int[]{3,3,0,3});
		for(List<Integer> list : ans){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

}
