package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();        
        Stack<TreeNode> stack = new Stack<>();  
        TreeNode current = root;
        while(current != null || !stack.isEmpty()){        	
        	while(current != null){        		
        		stack.push(current);
        		current = current.left;
        	}
        	if(!stack.empty()){
	        	current = stack.pop();
	        	ans.add(current.val);
	        	current = current.right;	        
        	}
        }
        return ans;
    }
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(inorderTraversal(a));
	}
}
