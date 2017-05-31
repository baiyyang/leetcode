package baiyyang;

public class MedianofTwoSortedArraysBinary {
	
	public static double solve(int[] num1 , int[] num2){
		
		if(num1.length > num2.length){
			return solve(num2, num1);
		}
		
		int i = 0 , j = 0;
		int leftmax = 0 , rightmin = 0;
		int imin = 0 , imax = num1.length;
		int sum = (num1.length + num2.length + 1)/2;
		while(imin <= imax){
			i = (imin + imax)/2;
			j = sum - i;
  			if(i<num1.length && num2[j-1] > num1[i]){
				imin = i+1;
			}
			else if(i>0 && num1[i-1] > num2[j]) {
				imax = i-1;
			}
			else {
				if(i == 0){
					leftmax = num2[j-1];
				}
				else if(j==0) {
					leftmax = num1[i-1]; 
				}
				else {
					leftmax = Math.max(num1[i-1], num2[j-1]);
				}
				break;
				
			}
  			
  			
		}
		if((num1.length + num2.length)%2 == 1){
			return leftmax;
		}
		else {
			if(i==num1.length){
				rightmin = num2[j];
			}
			else if (j==num2.length) {
				rightmin = num1[i];
			}
			else {
				rightmin = Math.min(num1[i], num2[j]);
			}
			return (leftmax + rightmin) / 2.0;
		}
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(solve(new int[]{1,3}, new int[]{2}));
	}
		
}
