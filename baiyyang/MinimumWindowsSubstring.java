package baiyyang;

public class MinimumWindowsSubstring {
	
	public static boolean isContains(int[] mapS , int[] mapT){
		for(int i=0;i<mapT.length;i++){
			if(mapT[i] > mapS[i]){
				return false;
			}
		}
		return true;
	}
	
    public static String minWindow(String s, String t) {
    	String ans = "";
    	int[] mapS = new int[256];
    	int[] mapT = new int[256];
    	int left = 0;
    	int right = 0;
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<t.length();i++){
    		mapT[t.charAt(i)]++;
    	}
    	while(left < s.length()){
    		while(!isContains(mapS, mapT) && right < s.length()){
    			mapS[s.charAt(right)]++;
    			right++;
    		}
    		if(isContains(mapS, mapT) && min > right - left){
    			ans = s.substring(left, right);
    			min = right - left;
    		}
    		mapS[s.charAt(left)]--;
    		left++;
    	}
        return ans;
    }
    
	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));		
	}

}
