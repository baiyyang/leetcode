package dp;

public class LongestCommonSubstring {
	public static int ans(String s1 , String s2){
		Integer[][] nums = new Integer[s1.length() + 1][s2.length() + 1];
		for(int i=0;i<s1.length() + 1;i++){
			nums[i][0] = 0;
		}
		for(int i=0;i<s2.length() + 1;i++){
			nums[0][i] = 0;
		}
		for(int i=1;i<s1.length()+1;i++){
			for(int j=1;j<s2.length()+1;j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){
					nums[i][j] = nums[i-1][j-1] + 1;
				}
				else {
					nums[i][j] = Math.max(nums[i-1][j], nums[i][j-1]);
				}
			}
		}
		return nums[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(ans("asddsadas", "ewqasdasd"));
	}

}
