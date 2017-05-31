package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
        	return ans;
        }
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        ans.add(first);        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);        
        while(!queue.isEmpty()){
        	int count = queue.size();
        	List<Integer> level = new ArrayList<>();
        	while(count > 0){
	        	TreeNode current  = queue.poll();
	        	count--;
	        	if(current.left != null){
	        		queue.offer(current.left); 
	        		level.add(current.left.val);
	        	}
	        	if(current.right != null){
	        		queue.offer(current.right);
	        		level.add(current.right.val);
	        	}
        	}
        	if(level.size() > 0)
        		ans.add(level);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		b.left = a;
		System.out.println(levelOrder(b));
	}

}
