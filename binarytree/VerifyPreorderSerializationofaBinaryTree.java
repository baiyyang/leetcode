package binarytree;

public class VerifyPreorderSerializationofaBinaryTree {

	public boolean isValidSerialization(String preorder) {
        int leaves = 0;
        int noleaves = 0;
        int i = 0;
        String[] nodes = preorder.split(",");
        for(i=0;i<nodes.length && noleaves + 1 != leaves;i++){
        	if(nodes[i].equals("#"))
        		leaves ++;
        	else {
				noleaves++;
			}
        }
        return noleaves + 1 == leaves && i==nodes.length;
    }	
	
	
	public boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        int ans = 1;       //outdegree - indegree
        for(int i=0;i<nodes.length;i++){
        	ans --;
        	if(ans < 0)
        		return false;
        	if(!nodes[i].equals("#"))
        		ans += 2;
        }
        return ans == 0;
    }	
}
