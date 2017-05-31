package baiyyang;

public class JumpGameII {
	
	//BFS深度优先搜索
	public static int solve(int[] nums){
		if(nums.length < 2)
			return 0;
		int currentMax = 0;
		int nextMax = 0;
		int ans = 0;
		int i = 0;
		while(currentMax - i + 1 > 0){
			ans ++;
			for(;i<=currentMax;i++){
				nextMax = Math.max(nextMax, nums[i] + i);
				if(nextMax >= nums.length - 1){
					return ans;
				}
			}
			currentMax = nextMax;
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(solve(new int[]{1,2,1,1,1}));
	}

}
