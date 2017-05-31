package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtracking(ans, new ArrayList<Integer>(), nums);
        return ans;
    }
	
	public void backtracking(List<List<Integer>> ans , List<Integer>list , int[] nums){
		if(list.size() == nums.length)
			ans.add(new ArrayList<Integer>(list));
		else {
			for(int i=0;i<nums.length;i++){
				if(list.contains(nums[i]))
					continue;
				list.add(nums[i]);
				backtracking(ans, list, nums);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> permute2(int[] nums){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		backtracking2(ans, new ArrayList<Integer>(), nums , 0);
		return ans;
	}
	
	public void backtracking2(List<List<Integer>> ans , List<Integer> list , int[] nums , int start){
		if(list.size() == nums.length){
			ans.add(new ArrayList<Integer>(list));
		}else {
			for(int i=start;i<nums.length;i++){
				if(list.contains(nums[i]))
					continue;
				list.add(nums[i]);
				backtracking2(ans, list, nums, start);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		List<List<Integer>> ans = permutations.permute2(new int[]{1,2,3});
		for(List<Integer> list : ans){
			System.out.println(Arrays.toString(list.toArray()));
		}
	}

}
