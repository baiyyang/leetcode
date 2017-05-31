package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	
	private static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visit = new boolean[m][n];		
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j] == 0){
					visit[i][j] = true;
					queue.offer(new Integer[]{i,j});
				}
			}
		}
		while(!queue.isEmpty()){
			Integer[] cur = queue.poll();
			for(int[] d : dir){
				int x = cur[0]+d[0];
				int y = cur[1]+d[1];
				if(x>=0 && x < m && y >= 0 && y < n && !visit[x][y]){
					visit[x][y] = true;
					int val = matrix[cur[0]][cur[1]];
					matrix[x][y] = val+1;
					queue.offer(new Integer[]{x,y});
				}
			}
		}
		
		return matrix;
    }
	
	
	public static void main(String[] args) {
		int[][] nums = new int[][]{{0,1,0,1,1},
			{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
		int[][] ans = updateMatrix(nums);
		for(int i=0;i<ans.length;i++){
			for(int j=0;j<ans[0].length;j++){
				System.out.print(ans[i][j]+",");
			}
			System.out.println();
		}
		
	}
}
