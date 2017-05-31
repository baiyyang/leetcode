package baiyyang;

import java.util.HashMap;
import java.util.Map;

public class IntegertoRoman {
	
	public static String intToRoman(int num) {
		StringBuffer ans = new StringBuffer();	
		Map<Integer , String> map = new HashMap<Integer, String>();
		map.put(9, "IX");
		//map.put(99, "IC");
		//map.put(999, "IM");
		map.put(90, "XC");
		//map.put(990 , "XM");
		map.put(900, "CM");
		map.put(4, "IV");
		//map.put(49, "IL");
		//map.put(40, "XL");
		//map.put(499, "ID");
		//map.put(490, "XD");
		//map.put(400, "CD");
		
		//千位
		int thousand = num/1000;
		while(thousand>0){
			ans.append("M");
			thousand--;
		}
		if(map.containsKey(num%1000)){
			ans.append(map.get(num%1000));
		}
		else {
			
			//百位
			int hundred = (num % 1000)/100;
			if(hundred < 4){
				while(hundred > 0){
					ans.append("C");
					hundred--;
				}
			}
			else if(hundred == 4) {
				ans.append("CD");
			}
			else if(hundred>4 && hundred <=8) {
				ans.append("D");
				hundred -= 5;
				while (hundred > 0) {
					ans.append("C");
					hundred--;					
				}
			}
			else {
				ans.append("CM");
			}
			
			//十位
			int s = (num%100)/10;
			if(s < 4){
				while (s>0) {
					ans.append("X");
					s--;					
				}
			}
			else if(s == 4){
				ans.append("XL");
			}
			else if(s > 4 && s<9){
				ans.append("L");
				s -= 5;
				while (s>0) {
					ans.append("X");
					s--;					
				}
			}
			else {
				ans.append("XC");
			}
			
			//个位
			int g = num%10;
			if(g<4){
				while (g>0) {
					ans.append("I");
					g--;
				}
			}
			else if (g==4) {
				ans.append("IV");
			}
			else if(g > 4 && g<9){
				ans.append("V");
				g -= 5;
				while(g>0){
					ans.append("I");
					g--;				
				}
			}
			else {
				ans.append("IX");
			}
		}
		return ans.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(3999));
	}

}
