/*

Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of 
water it can trap after raining.

Example 1:
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.

Example 2:
Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10

Constraints:
m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104

*/

import java.util.PriorityQueue;

class Rain{

	static boolean isValid(int x, int y, int m, int n){
		
		return x >= 0 && x < m && y >= 0 && y < n;
		
	}

	static int trapRainWater(int[][] heightMap){
		
		int m = heightMap.length;
		int n = heightMap[0].length;
		
		if(m < 3 || n < 3)
			return 0;
		
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		boolean[][] visited = new boolean[m][n];
		
		for(int i = 0; i < m; i++){
			
			for(int j = 0; j < n; j++){
				
				if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
					
					minHeap.offer(new int[] {heightMap[i][j], i, j});
					visited[i][j] = true;
					
				}
				
			}
			
		}
		
		// Apply BFS
		int level = 0;
		int trappedWater = 0;
		int[] dir = {-1, 0 , 1, 0, -1};
		
		while(!minHeap.isEmpty()){
			
			int[] curr = minHeap.poll();
			int height = curr[0];
			int x = curr[1];
			int y = curr[2];
			level = Math.max(level, height);
			
			for(int i = 0; i < 4; i++){
				
				int newX = x + dir[i];
				int newY = y + dir[i + 1];
				if(isValid(newX, newY, m, n) && !visited[newX][newY]){
					
					visited[newX][newY] = true;
					minHeap.offer(new int[] {heightMap[newX][newY], newX, newY});
					if(heightMap[newX][newY] < level){
						
						trappedWater += level - heightMap[newX][newY];
						
					}
					
				}
				
			}
			
		}
		
		return trappedWater;
		
	}
	
	public static void main(String[] args){
		
		int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.print(trapRainWater(heightMap));
		
	}
	
}