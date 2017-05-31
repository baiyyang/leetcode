package baiyyang;

public class StudentAttendanceRecordI {
	
	public static boolean checkRecord(String s) {
        int a = 0;                
        boolean ans = true;
        if(s.indexOf("LLL") != -1){
        	return false;
        }
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == 'A'){
        		a++;
        		if(a > 1){
        			ans = false;
        			break;
        		}        			
        	}        	
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(checkRecord("LALL"));
	}

}
