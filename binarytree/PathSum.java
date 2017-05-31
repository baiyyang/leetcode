package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
        	return false;
        if(root.left == null && root.right == null && sum == root.val){
			return true;
		}
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
	
	private List<List<Integer>> ans = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		helper(root, sum, new ArrayList<Integer>());
		return ans;
    }
	
	public void helper(TreeNode root , int sum , List<Integer> current){
		if(root == null){			
			return;
		}
		if(root.left == null && root.right == null && sum == root.val){
			current.add(root.val);		
			ans.add(new ArrayList<Integer>(current));
			current.remove(current.size() - 1);
			return;
		}
		sum -= root.val;
		current.add(root.val);
		helper(root.left, sum, current);
		helper(root.right, sum, current);
		current.remove(current.size() - 1);
	}
		
	public int pathSum2(TreeNode root, int sum) {    
		if(root == null)
			return 0;
        return help2(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);         
    }
	
	public int help2(TreeNode root , int sum){
		if(root == null)
        	return 0;
        if(root.val == sum)
        	return help2(root.left, sum-root.val) + help2(root.right, sum-root.val) + 1;
        return help2(root.left, sum-root.val) + help2(root.right, sum-root.val);
        
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(-2);
		TreeNode b = new TreeNode(-3);
		a.right = b;
		PathSum sum = new PathSum();
		System.out.println(sum.pathSum(a, -5).size());
	}
}
