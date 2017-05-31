package baiyyang;

public class PalindromeNumber {
	
	public static boolean solve(int x) {
		int s = x;
		int y = 0;
		int ans = 0;
		while(x > 0){
			y = x % 10;
			ans = ans * 10 + y;
			x /= 10;			
		}
		if(ans == s)
			return true;
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solve(101));
	}

}
