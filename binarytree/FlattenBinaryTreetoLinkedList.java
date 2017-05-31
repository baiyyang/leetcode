package binarytree;

public class FlattenBinaryTreetoLinkedList {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode pre = null;
	public void flatten(TreeNode root) {
        if(root != null){        	
        	flatten(root.right);
        	flatten(root.left);
        	root.right = pre;
        	root.left = null;
        	pre = root;
        }
    }
	
	
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		FlattenBinaryTreetoLinkedList l = new FlattenBinaryTreetoLinkedList();
		l.flatten(a);
		while(a != null){
			System.out.println(a.val);
			a = a.right;
		}
	}
}
