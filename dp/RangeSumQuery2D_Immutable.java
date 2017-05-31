package dp;

public class RangeSumQuery2D_Immutable {	
	
	static class NumMatrix {

		public int[][] matrix;
		
		public int[][] ans;
		
	    public NumMatrix(int[][] matrix) {
	        this.matrix = matrix;
	        start();
	        
	    }
	    
	    public int sumRegion(int row1, int col1, int row2, int col2) {		    	
	        return ans[row2+1][col2+1] - ans[row2+1][col1] - ans[row1][col2+1] + ans[row1][col1];
	    }
	    
	    public void start(){
	    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
	    		return;
	    	ans = new int[matrix.length + 1][matrix[0].length + 1];	
	    	int m = matrix.length;
	    	int n = matrix[0].length;
	    	for(int i=1;i<=m;i++){
	    		for(int j=1;j<=n;j++){	    			
	    			ans[i][j] = ans[i-1][j] + ans[i][j-1] - ans[i-1][j-1] + matrix[i-1][j-1];
	    		}
	    	}	    	    
	    }
	    
	    public static void main(String[] args) {
			//int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
	    	int[][] matrix = null;
			NumMatrix m = new NumMatrix(matrix);
			System.out.println(m.sumRegion(2, 1, 4, 3));
	}
	}
}
