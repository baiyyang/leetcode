package baiyyang;

public class MedianofTwoSortedArrays {
	
	public static double solve(int[] num1 , int[] num2){
		int i=0 , j=0 , count=0;
		int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,current=0;
		while(i<num1.length && j<num2.length){
			if(i<num1.length && num1[i] > num2[j]){
				count++;
				current = num2[j];
				j++;
			}
			if(j<num2.length && num1[i] < num2[j]){
				count++;
				current = num1[i];
				i++;
			}
			if(count == (num1.length + num2.length)/2){
				a = current;
			}
			if(count == (num1.length + num2.length)/2 + 1){
				b = current;
				break;
			}
		}
		if(b==Integer.MAX_VALUE){
			while(i<num1.length){
				count++;
				current = num1[i];
				i++;
				if(count == (num1.length + num2.length)/2){
					a = current;
				}
				if(count == (num1.length + num2.length)/2 + 1){
					b = current;
					break;
				}
			}
		}
		if(b==Integer.MAX_VALUE){
			while(j<num2.length){
				count++;
				current = num2[j];
				j++;
				if(count == (num1.length + num2.length)/2){
					a = current;
				}
				if(count == (num1.length + num2.length)/2 + 1){
					b = current;
					break;
				}
			}
		}
		if((num1.length + num2.length)%2 == 0){
			return (a+b)/2.0;
		}
		else {
			return b;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solve(new int[]{1,2}, new int[]{3,4}));
	}

}
