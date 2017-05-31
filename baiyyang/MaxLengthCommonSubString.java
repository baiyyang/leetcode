package baiyyang;

public class MaxLengthCommonSubString {

	public static int solve(String a , String b){
		if("".equals(a) || "".equals(b)){
			return 0;
		}
		else {
			if(a.charAt(a.length() - 1) == b.charAt(b.length() - 1)){
				return solve(a.substring(0, a.length()-1), b.substring(0 , b.length() - 1)) + 1;
			}
			else {
				return Math.max(solve(a.substring(0, a.length()-1), b), solve(a, b.substring(0 , b.length() - 1)));
			}
			
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solve("abcdefg" , "bscdegds"));
	}
}
