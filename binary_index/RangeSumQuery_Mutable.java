package binary_index;

public class RangeSumQuery_Mutable {

	public int[] nums;
	public int[] trees;
	
	public RangeSumQuery_Mutable(int[] nums) {
        this.nums = nums;
        int lowbit = 0;
        trees = new int[nums.length+1];        
        for(int i=0;i<trees.length;i++){
        	int sum = 0;
        	lowbit = i&(-i);
        	for(int j=i;j>i-lowbit;j--){
        		sum += nums[j-1];
        	}
        	trees[i] = sum;
        }
    }
    
    public void update(int i, int val) {
    	int sub = val - nums[i];
    	nums[i] = val;
    	i++;
    	for(;i < trees.length;i+=i&(-i)){
        	trees[i] += sub;
        }
        
    }
    
    public int sumRange(int i, int j) {    	
        return getSum(j) - getSum(i-1);
    }
    
    public int getSum(int i){
    	int sum = 0;
    	i++;
    	while(i>0){
    		sum += trees[i];
    		i -= i&(-i);
    	}
    	return sum;
    }
    
    public static void main(String[] args) {
		RangeSumQuery_Mutable mutable = new RangeSumQuery_Mutable(new int[]{-1});
		System.out.println(mutable.sumRange(0, 0));
		mutable.update(0,1);
		System.out.println(mutable.sumRange(0, 0));    	
		
	}
}
