package baiyyang;

public class ValidParentheses {
	
	public static boolean isValid(String s) {
        char[] num = new char[s.length()];
        int a = 0;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
        		num[a] = s.charAt(i);
        		a++;
        	}
        	else if (s.charAt(i) == ')') {
				a--;
				if(a >= 0 && num[a] == '(')
					continue;
				else {
					return false;
				}
			}
        	else if (s.charAt(i) == ']') {
				a--;
				if(a >= 0 && num[a] == '[')
					continue;
				else {
					return false;
				}
			}
        	else if (s.charAt(i) == '}') {
				a--;
				if(a >= 0 && num[a] == '{')
					continue;
				else {
					return false;
				}
			}
        }
        if(a != 0)
        	return false;
        else
        	return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isValid("["));
	}

}
