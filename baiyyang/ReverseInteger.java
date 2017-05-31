package baiyyang;

public class ReverseInteger {

	public static int solve(int x){
		long ans = 0;
		int m = 0;
		while(x != 0){
			m = x % 10;
			x = x / 10;
			ans = (ans + m) * 10;
			if(ans/10 > Integer.MAX_VALUE || ans/10 < Integer.MIN_VALUE){
				return 0;
			}
			
		}
		ans /= 10;
		return (int) ans;
	}
	public static void main(String[] args) {
		System.out.println(solve(-2147483412));
		
	}
}
