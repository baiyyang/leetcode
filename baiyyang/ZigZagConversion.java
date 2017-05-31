package baiyyang;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
        StringBuffer[] buffers = new StringBuffer[numRows];
        for(int i=0;i<buffers.length;i++){
        	buffers[i] = new StringBuffer();
        }
        int i=0;
        while(i<s.length()){
        	for(int j=0;j<buffers.length && i<s.length();j++){
        		buffers[j].append(s.charAt(i));
        		i++;
        	}
        	for(int j=buffers.length-2;j>0 && i<s.length();j--){
        		buffers[j].append(s.charAt(i));
        		i++;
        	}
        }
        for(int k=1;k<numRows;k++){
        	buffers[0].append(buffers[k]);
        }
        return buffers[0].toString();
    }
	public static void main(String[] args) {
		System.out.println(convert("ABCDEFGHIJK", 4));
	}
}
