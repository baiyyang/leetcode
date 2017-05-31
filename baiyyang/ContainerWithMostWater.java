package baiyyang;


public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int start = 0;
		int end = height.length-1;
		int ans = 0;
		while(start < end){
			ans = Math.max(ans, Math.min(height[start], height[end]) * (end - start));
			if(height[start] > height[end]){				
					end--;
			}
				
			else {						
					start++;
			}
		}
		return ans;        
    }
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1, 2,4,3}));
	}

}
