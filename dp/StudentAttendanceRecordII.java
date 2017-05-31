package dp;

public class StudentAttendanceRecordII {
	
	public static int checkRecord(int n) {
		long M = (long) (Math.pow(10, 9) + 7);
        long[] pl = new long[n+1];
        long[] p = new long[n+1];       
        p[0] = 1;
        p[1] = 1;
        pl[0] = 1;
        pl[1] = 2;
        for(int i=2;i<=n;i++){
        	p[i] = pl[i-1];
        	pl[i] = (p[i-1] + p[i] + p[i-2])%M;
        }
        long ans = pl[n];
        for(int i=0;i<n;i++){
        	long a = (pl[i]*pl[n-i-1])%M;
        	ans = (ans + a)%M;
        }
        return (int)ans;
    }
	
	public static void main(String[] args) {
		System.out.println(checkRecord(2));
	}

}
