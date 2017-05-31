package binarytree;

import java.awt.List;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

	static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer ans = new StringBuffer();
        if(root == null)
        	return ans.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);       
        while(!queue.isEmpty()){
        	TreeNode current = queue.poll();  
        	if(current == null){
        		ans.append("n,");
        		continue;
        	}
        	ans.append(current.val + ",");
        	if(current.left != null){
        		queue.offer(current.left);        		
        	}else {
				queue.offer(null);	
			}
        	if(current.right != null){
        		queue.offer(current.right);
        	}else {
				queue.offer(null);
			}
        }
        return ans.toString();
     }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data)){
        	return null;
        }
        String[] datas = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(datas[0]));
        queue.offer(root);
        int i = 1;
        while(i<datas.length){        
        	TreeNode current = queue.poll();
        	if(!datas[i].equals("n")){
        		TreeNode left = new TreeNode(Integer.valueOf(datas[i]));
        		queue.offer(left);
        		current.left = left;
        	}
        	i++;
        	if(!datas[i].equals("n")){
        		TreeNode right = new TreeNode(Integer.valueOf(datas[i]));
        		queue.offer(right);
        		current.right = right;
        	}
        	i++;
        }
        return root;
        
    }
    
    public void preorder(TreeNode root){
    	if(root != null){
    		System.out.println(root.val);
    		preorder(root.left);
    		preorder(root.right);
    	}
    }
    
    public static void main(String[] args) {
		SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		b.left = c;
		System.out.println(s.serialize(a));
		s.preorder(s.deserialize(s.serialize(a)));
	}
    
}
