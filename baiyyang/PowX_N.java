package baiyyang;

public class PowX_N {
	
	public static void main(String[] args) {
		System.out.println(myPow(-1.00000,-2147483648));
	}
	
	public static double myPow(double x, int n) {
		if(x == 0)
			return 0;
		if(n == 0)
        	return 1;          
		if(n<0){
			x = 1/x;
			if(n == Integer.MIN_VALUE){
				n = Integer.MAX_VALUE;
				return x*myPow(x, n);
			} else {
				n = -n;
			}
		}
        if(n%2==0){
        	return myPow(x*x, n/2);
        } else {
			return x*myPow(x*x, n/2);
		}
    }

}
