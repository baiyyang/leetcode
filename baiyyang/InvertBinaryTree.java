package baiyyang;

public class InvertBinaryTree {
	
	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static TreeNode invertTree(TreeNode root) {
        if(root != null){
        	TreeNode left = invertTree(root.left);
        	TreeNode right = invertTree(root.right);
        	root.left = right;
        	root.right = left;
        }
        return root;
    }
	
	public static void print(TreeNode root){
		if(root != null){
			System.out.print(root.val);
			print(root.left);
			print(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		print(a);
		System.out.println();
		print(invertTree(a));
	}

}
