package baiyyang;

public class IntegerBreak {
		
	public static int integerBreak(int n) {
        if(n == 2){
        	return 1;
        }
        if(n == 3){
        	return 2;
        }
        else {
        	int ans = 1;
			while(n>4){
				ans *= 3;
				n -= 3;
			}
			ans *= n;
			return ans;
		}
    }

	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}

}
