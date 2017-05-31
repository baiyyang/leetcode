package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
        	return ans;
        queue.offer(root);
        List<Integer> current = new ArrayList<Integer>();     
        current.add(root.val);
        ans.add(current);
        while(!queue.isEmpty()){        	
        	int len = queue.size();
        	List<Integer> level = new ArrayList<Integer>();
        	while(len > 0){
        		TreeNode c = queue.poll();        		
        		len --;
        		if(c.left != null){
        			queue.offer(c.left);
        			level.add(c.left.val);
        		}
        		if(c.right != null){
        			queue.offer(c.right);
        			level.add(c.right.val);
        		}        			
        	}
        	if(level.size() > 0)
        		ans.add(0 ,level);        	
        }
        /*List<List<Integer>> ans2 = new ArrayList<List<Integer>>();
        for(int i=ans.size()-1;i>=0;i--){
        	ans2.add(ans.get(i));
        }*/
        return ans;
    }
}
