package binarytree;

public class CountCompleteTreeNodes {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int countNodes(TreeNode root) {        
		if(root == null)
			return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	
	
	public int countCompleteTreeNodes(TreeNode root){
		if(root == null)
			return 0;
		TreeNode left = root;
		TreeNode right = root;
		int height = 0;
		while(right != null){
			left = left.left;
			right = right.right;
			height ++;
		}
		if(left == null)
			return (1 << height) - 1;
		return 1 + countCompleteTreeNodes(root.left) + countCompleteTreeNodes(root.right);
	}
}
