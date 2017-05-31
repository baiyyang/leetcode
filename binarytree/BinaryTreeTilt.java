package binarytree;

public class BinaryTreeTilt {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static int ans = 0;
	
	public static int findTilt(TreeNode root) {
        postorder(root);
        return ans;
		                
    }
	
	public static int postorder(TreeNode root){
		if(root == null)
			return 0;
		int left = postorder(root.left);
		int right = postorder(root.right);
		ans += Math.abs(left - right);
		return left + right + root.val;
	}
}
