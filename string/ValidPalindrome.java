package string;

public class ValidPalindrome {
	
	public static boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<s.length();i++){
        	if((s.charAt(i) >= '0' && s.charAt(i) <= '9' ) || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
        			(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
        		buffer.append(lowwer(s.charAt(i)));
        	}
        }
        String ans = buffer.toString();
        for(int i=0;i<ans.length()/2;i++){
        	if(ans.charAt(i) != ans.charAt(ans.length() - 1 - i)){
        		return false;
        	}
        }
        return true;
    }
	
	public static char lowwer(char c){
		if(c >= '0' && c <= '9')
			return c;
		else if(c >= 'a' && c <= 'z')
			return c;
		else {
			return (char) (c+32);
		}
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}

}
