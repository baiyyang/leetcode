package trie;

public class MaximumXORofTwoNumbersinanArray {
	
	class Trie{
		public Trie[] children = new Trie[2];
	}
	
	public int findMaximumXOR(int[] nums) {
		Trie root = new Trie();
		if(nums == null || nums.length < 2)
			return 0;
        for(int i=0;i<nums.length;i++){
        	Trie currentNode = root;
        	for(int j=31;j>=0;j--){
        		int currentBit = (nums[i] >> j) & 1;
        		if(currentNode.children[currentBit] == null)
        			currentNode.children[currentBit] = new Trie();
        		currentNode = currentNode.children[currentBit];
        	}
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums){
        	Trie currentNode = root;
        	int cur = 0;
        	for(int i=31;i>=0;i--){
        		//每次都找与currenBit相反的分支，即最大的分支
        		int currentBit = (num >> i) & 1;
        		int temp = 1 - currentBit;
        		if(currentNode.children[temp] != null){
        			cur += (1 << i);
        			currentNode = currentNode.children[temp];
        		}
        		else {
					currentNode = currentNode.children[currentBit];
				}
        		
        		if (cur < max && max - cur >= (1 << i) - 1) {
                    break;
                }
        	}
        	max = Math.max(cur, max);
        }
        return max;
        
    }

}
