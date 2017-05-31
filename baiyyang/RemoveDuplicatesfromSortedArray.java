package baiyyang;

public class RemoveDuplicatesfromSortedArray {
	
	public static int removeDuplicates(int[] nums) {
		int i = 1;
		int ans = 1;
		int length = nums.length;
		while(i<length){
			if(nums[i] == nums[i-1]){
				for(int j=i;j<length;j++){
					nums[j-1] = nums[j];
				}
				length --;
			}
			else {
				ans++;
				i++;
			}
			
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1};
		int a = removeDuplicates(nums);
		for(int i=0;i<a;i++){
			System.out.println(nums[i]);
		}
	}

}
