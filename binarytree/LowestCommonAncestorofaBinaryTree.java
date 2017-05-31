package binarytree;

public class LowestCommonAncestorofaBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return null;
        else if (root == p) {
			return p;
		}
        else if (root == q) {
			return q;
		}
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)
        	return right;
        else if(right == null)
        	return left;		
		else{
			return root;
		}
    }
	
	public static TreeNode lowestCommonAncestorSearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return null;
         if(root.val > p.val && root.val > q.val)
        	 return lowestCommonAncestorSearchTree(root.left, p, q);
         else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestorSearchTree(root.right, p, q);
		}
         else {
			return root;
		}
    }
}
