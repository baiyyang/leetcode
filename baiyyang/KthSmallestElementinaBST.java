package baiyyang;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestElementinaBST {

	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public static int kthSmallest(TreeNode root, int k) {
		if(root != null){
			int count = count(root.left);
	        if(count == k-1){
	        	return root.val;
	        }
	        else if (count > k - 1) {
				return kthSmallest(root.left, k);
			}
	        else {
				return kthSmallest(root.right, k-count-1);
			}
		}
		return -1;
    }
	
	public static int count(TreeNode root){
		if(root == null)
			return 0;
		int ans = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();			
			if(current.left != null){
				queue.offer(current.left);
				ans++;
			}
			if(current.right != null){
				queue.offer(current.right);
				ans++;
			}
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		b.left = a;
		System.out.println(kthSmallest(b, 1));
	}
}
