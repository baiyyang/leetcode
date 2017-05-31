package binarytree;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1);  
    }
	
	public static TreeNode build(int[] preorder , int start , int end , int[] inorder , int startin ,int endin){
		if(start > end || startin > endin)
			return null;
		TreeNode root = new TreeNode(preorder[start]);
		int i = startin;
		for(i=startin;i<=endin;i++){
			if(inorder[i] == preorder[start])
				break;
		}
		root.left = build(preorder, start+1, end, inorder, startin, i-1);
		root.right = build(preorder, start+i-startin+1, end, inorder, i+1, endin);
		return root;
	}
	
	public static void print(TreeNode root){
		if(root != null){
			System.out.println(root.val);
			print(root.left);
			print(root.right);
		}
	}
	
	public static void main(String[] args) {
		int[] preorder = new int[]{1,2};
		int[] inorder = new int[]{2,1};
		print(buildTree(preorder, inorder));
	}
}
