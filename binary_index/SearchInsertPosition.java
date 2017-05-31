package binary_index;

import java.util.Arrays;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		if(nums == null)
			return 0;
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start)/2;	
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				end = mid - 1;
			else {
				start = mid + 1;
			}
		}
		return start;
    }		
}
