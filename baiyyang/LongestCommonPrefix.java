package baiyyang;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
        StringBuffer ans = new StringBuffer();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
        	if(strs[i].length() < min)
        		min = strs[i].length();
        }
        
        for(int i=0;i<min;i++){
        	int flag = 0;
        	char sign = strs[0].charAt(i);
        	for(int j=0;j<strs.length;j++){
        		if(strs[j].charAt(i) != sign){
        			flag = 1;
        			break;
        		}
        	}
        	if(flag == 0){
        		ans.append(sign);
        	}
        	else {
				break;
			}
        }
        return ans.toString();
        
    }
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{}));
	}

}
