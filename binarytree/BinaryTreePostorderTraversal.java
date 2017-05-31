package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
        	return ans;
        }        
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode current = stack.peek();
        	if((current.left == null && current.right == null) || (pre != null && (pre == current.left || pre == current.right))){
        		ans.add(current.val);
        		pre = current;
        		stack.pop();
        	}
        	else{
	        	if(current.right != null) {
					stack.push(current.right);
				}
	        	if(current.left != null){
	        		stack.push(current.left);
	        	}
        	}
        }
        return ans;
    }
	
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null)
        	return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){        	
        	while(current != null){
        		ans.add(current.val);
        		stack.push(current);
        		current = current.left;
        	}
        	current = stack.pop();
        	current = current.right;        	
        }
        return ans;
    }

}
