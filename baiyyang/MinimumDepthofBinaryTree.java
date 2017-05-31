package baiyyang;

public class MinimumDepthofBinaryTree {

	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else if(root.left == null && root.right == null){
        	return 1;
        }
        else if(root.left != null && root.right == null) {
			return minDepth(root.left)+1;
		}
        else if (root.left == null && root.right != null) {
			return minDepth(root.right) + 1;
		}
        else {
			int left = minDepth(root.left);
			int right = minDepth(root.right);
			return Math.min(left, right) + 1;
		}
    }
}
