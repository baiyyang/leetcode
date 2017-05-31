package binarytree;

public class BinaryTreeMaximumPathSum {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	static int max = Integer.MIN_VALUE;
	
	public static int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
	
	public static int maxPath(TreeNode root){
		if(root == null)
			return 0;
		int left = Math.max(maxPath(root.left) , 0);
		int right = Math.max(maxPath(root.right) , 0);
		int current = left + right + root.val;
		max = Math.max(max, current);
		return root.val + Math.max(left, right);
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		System.out.println(maxPathSum(a));
	}
}
