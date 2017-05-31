package binary_index;

public class ValidPerfectSquare {

	public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
        	int mid = start + (end - start)/2;
        	if(mid > num/mid){
        		end = mid - 1;
        	}
        	else if (mid == num / mid && num % mid == 0) {
				return true;
			}
        	else {
				start = mid + 1;
			}
        }
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(isPerfectSquare(5));
	}
}
