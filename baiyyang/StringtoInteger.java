package baiyyang;

public class StringtoInteger {
	
	public static int ans(String str){
		char[] nums = str.trim().toCharArray();
		int ans = 0;
		int flag = 1;
		if(nums.length == 0){
			return 0;
		}
		else {
			for(int i=0;i<nums.length;i++){
				if(i==0 && nums[i] == '-'){
					flag = -1;
				}
				else if(i==0 && nums[i] == '+')
					continue;
				else {
					if(nums[i] >= '0' && nums[i] <= '9'){						
						if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && (nums[i] - '0' > (Integer.MAX_VALUE % 10))))
							return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
						ans = ans*10 + (nums[i]-'0');
					}
					else {
						break;
					}
				}
			}
			return flag * ans;
		}
			
				
	}
	public static void main(String[] args) {
		System.out.println(ans("-2147483649"));
		
	}

}
