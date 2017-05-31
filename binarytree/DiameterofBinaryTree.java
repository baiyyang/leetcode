package binarytree;

public class DiameterofBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        	return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        int ans = left + right;
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), ans);
    }
	
	public int depth(TreeNode root){
		if(root == null)
			return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}
