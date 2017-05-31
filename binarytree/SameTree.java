package binarytree;

public class SameTree {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        	return true;
        else if(p != null && q != null) {
        	if(p.val == q.val){
            	return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else {
    			return false;
    		}
		}
        else {
			return false;
		}        
    }

}
