package baiyyang;

public class H_IndexII {
	
	public static int hIndex(int[] citations) {
		int ans = 0;
        for(int i=citations.length-1;i>=0;i--){
        	if(citations[i] >= citations.length-i){
        		if(ans < citations.length-i)
        			ans = citations.length-i;        		
        	}
        }
        return ans;
    }

	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{3,0,6,1,5}));
	}
}
