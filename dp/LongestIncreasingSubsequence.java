package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	//�ֽ���������ת��ΪLCS��O(n2)
	public static int lengthOfLIS1(int[] nums) {        
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int length = nums.length;
        int[] sortNums = nums.clone();        
        Arrays.sort(sortNums);        
        int[] uniqueNums = new int[length];
        uniqueNums[0] = sortNums[0];
        int count = 0;
        for(int i=1;i<length;i++){
        	if(sortNums[i] != uniqueNums[count]){
        		count ++;
        		uniqueNums[count] = sortNums[i];
        	}
        }
        int[][] dp = new int[length + 1][length + 1];
        for(int i=0;i<length;i++){
        	for(int j=0;j<=count;j++){
        		if(nums[i] == uniqueNums[j]){
        			dp[i+1][j+1] = dp[i][j] + 1;
        		}else {
					dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
        	}
        }
        return dp[length][count + 1];
    }
	
	//dp O(n2) dp[i]��ʾnum[i]��β�������������еĳ���
	public static int lengthOfLIS(int[] nums){ 
		if(nums == null || nums.length == 0)
			return 0;
		int n = nums.length;
        int[] dp = new int[n];//���ڴ��f(i)ֵ��
        dp[0]=1;//�Ե�a1ΪĩԪ�ص�����������г���Ϊ1��
        for(int i=1;i<n;i++)//ѭ��n-1��
        {
        	dp[i]=1;//f[i]����СֵΪ1��           
           for(int j=0;j<i;j++)//ѭ��i ��
           {        	   
              if(nums[j] < nums[i] && dp[j] > dp[i] - 1){            	  
            	  dp[i]=dp[j]+1;//����f[i]��ֵ��              
              }
           }
        }
        int max =0;
        for(int i=0;i<n;i++){
        	if(max < dp[i])
        		max = dp[i];
        }
        return max;      
	}	
	
	//binsearch
	public static int binsearch(int[] nums , int start , int end , int key){	
		if(nums[end] < key)
			return end + 1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(nums[mid] > key)
				end = mid - 1;
			else if(nums[mid] < key)
				start = mid + 1;
			else {
				return mid;
			}
		}
		return start;
	}
	
	//dp +��binsearch O(nlogn)
	public static int lengthOfLIS2(int[] nums){ 
		if(nums == null || nums.length == 0)
			return 0;
		int length = nums.length;
		int[] dp = new int[length + 1];
		dp[1] = nums[0];
		int max = 1;
		for(int i=1;i<length;i++){
			int position = binsearch(dp, 0, max, nums[i]);
			dp[position] = nums[i];
			if(max < position)
				max = position;
			
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLIS2(new int[]{-2,-1}));
	}
}
