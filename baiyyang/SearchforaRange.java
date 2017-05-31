package baiyyang;

public class SearchforaRange {
	
	public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binStartSearch(nums, target);
        ans[1] = binEndSearch(nums, target);
        return ans;
    }
	
	public static int binStartSearch(int[] nums , int target){
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target){
				if(mid - 1 >= 0 && nums[mid - 1] == target){
					end = mid - 1;
				}else {
					return mid;
				}
			} else if (nums[mid] > target) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static int binEndSearch(int[] nums , int target){
		int start = 0;
		int end = nums.length - 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(nums[mid] == target){
				if(mid + 1 < nums.length && nums[mid + 1] == target){
					start = mid + 1;
				}else {
					return mid;
				}
			} else if (nums[mid] > target) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] ans = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
		for(Integer i : ans){
			System.out.println(i);
		}
	}

}
