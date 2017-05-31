package binarytree;

import binarytree.ConstructBinaryTreefromPreorderandInorderTraversal.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
	
	public static TreeNode build(int[] inorder , int startin , int endin , int[] postorder , int startpost , int endpost){
		if(startin > endin || startpost > endpost ){
			return null;
		}
		TreeNode root = new TreeNode(postorder[endpost]);
		int index = startin;
		for(index = startin;index <= endin;index ++){
			if(inorder[index] == postorder[endpost])
				break;
		}
		root.left = build(inorder, startin, index-1, postorder, startpost, startpost + index - startin - 1);
		root.right = build(inorder, index + 1, endin, postorder, startpost + index - startin, endpost-1);
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
		int[] inorder = new int[]{2,1};
		int[] postorder = new int[]{2,1};
		print(buildTree(inorder, postorder));
	}
}
