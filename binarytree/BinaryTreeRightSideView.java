package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<Integer>();
		helper(root, ans, 0);
		return ans;
    }
	
	public static void helper(TreeNode root , List<Integer> ans , int depth){
		if(root == null)
			return;
		if(ans.size() == depth)
			ans.add(root.val);
		helper(root.right, ans, depth+1);
		helper(root.left, ans, depth+1);
	}
	
	public static void preorder(TreeNode root){
		if(root != null){
			System.err.println(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		a.left = b;
		System.out.println(rightSideView(a).toString());
		
	}
}
