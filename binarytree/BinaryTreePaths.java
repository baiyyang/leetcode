package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static List<String> ans = new ArrayList<String>();
	
	public static List<String> binaryTreePaths(TreeNode root) {
		paths(root, "");
		return ans;
    }
	
	public static void paths(TreeNode root , String path){
		if(root != null){
			if(root.left == null && root.right == null){
				ans.add(path + root.val);
			}
			else {
				path += root.val + "->";
				if(root.left != null)
					paths(root.left, path);
				if(root.right != null)
					paths(root.right, path);
			}			
		}		
	}
}
