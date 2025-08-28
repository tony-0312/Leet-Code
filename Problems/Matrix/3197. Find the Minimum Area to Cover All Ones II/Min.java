/*

You are given a 2D binary array grid. You need to find 3 non-overlapping rectangles having non-zero areas with 
horizontal and vertical sides such that all the 1's in grid lie inside these rectangles.

Return the minimum possible sum of the area of these rectangles.

Note that the rectangles are allowed to touch.

Example 1:
Input: grid = [[1,0,1],[1,1,1]]

Output: 5

Explanation:
The 1's at (0, 0) and (1, 0) are covered by a rectangle of area 2.
The 1's at (0, 2) and (1, 2) are covered by a rectangle of area 2.
The 1 at (1, 1) is covered by a rectangle of area 1.

Example 2:
Input: grid = [[1,0,1,0],[0,1,0,1]]

Output: 5

Explanation:
The 1's at (0, 0) and (0, 2) are covered by a rectangle of area 3.
The 1 at (1, 1) is covered by a rectangle of area 1.
The 1 at (1, 3) is covered by a rectangle of area 1.
 

Constraints:
1 <= grid.length, grid[i].length <= 30
grid[i][j] is either 0 or 1.
The input is generated such that there are at least three 1's in grid.

*/

class Min{
	
	static void findBoundingCoordinates(int[][] grid, int[] bounds){
		
		int m = grid.length;
		int n = grid[0].length;
		int low_x = Integer.MAX_VALUE;
		int high_x = -1;
		int low_y = Integer.MAX_VALUE;
		int high_y = -1;
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == 1){
					
					low_x = Math.min(low_x, i);
					high_x = Math.max(high_x, i);
					low_y = Math.min(low_y, j);
					high_y = Math.max(high_y, j);
					
				}
			}
		}
		
		bounds[0] = low_x;
		bounds[1] = high_x;
		bounds[2] = low_y;
		bounds[3] = high_y;
		
	}

	static int findMinArea(int x1, int x2, int y1, int y2, int[][] grid){
		
		int min_x = Integer.MAX_VALUE;
		int max_x = -1;
		int min_y = Integer.MAX_VALUE;
		int max_y = -1;
		
		for(int i = x1; i <= x2; i++){
			for(int j = y1; j <= y2; j++){
				
				if(grid[i][j] == 1){
					min_x = Math.min(min_x, i);
					max_x = Math.max(max_x, i);
					min_y = Math.min(min_y, j);
					max_y = Math.max(max_y, j);
				}
				
			}
		}
		
		if(min_x == Integer.MAX_VALUE || max_x == -1 || min_y == Integer.MAX_VALUE || max_y == -1){
			return 0;
		}
		
		return (max_x - min_x + 1) * (max_y - min_y + 1	);
		
	}
	
	static int minimumSum(int[][] grid){
		
		int[] b = new int[4];
		findBoundingCoordinates(grid, b);
		int low_x = b[0];
		int high_x = b[1];
		int low_y = b[2];
		int high_y = b[3];
		
		if(low_x == Integer.MAX_VALUE)
			return 0;
		
		int lowest_area = Integer.MAX_VALUE;
		
		//4-way L-shaped splits
		for(int i = low_x; i < high_x; i++){
			for(int j = low_y; j < high_y; j++){
				
				for(int count = 1; count <= 4; count++){
					
					int area = 0;
					switch(count){
						case 1:
							area = findMinArea(low_x, i, low_y, j, grid)
								 + findMinArea(low_x, i, j + 1, high_y, grid)
								 + findMinArea(i + 1, high_x, low_y, high_y, grid);
							break;
						
						case 2:
							area = findMinArea(low_x, high_x, low_y, j, grid)
								 + findMinArea(low_x, i, j + 1, high_y, grid)
								 + findMinArea(i + 1, high_x, j + 1, high_y, grid);
							break;
						
						case 3:
							area = findMinArea(low_x, i, low_y, high_y, grid)
								 + findMinArea(i + 1, high_x, low_y, j, grid)
								 + findMinArea(i + 1, high_x, j + 1, high_y, grid);
							break;
						
						case 4:
							area = findMinArea(low_x, i, low_y, j, grid)
								 + findMinArea(i + 1, high_x, low_y, j, grid)
								 + findMinArea(low_x, high_x, j + 1, high_y, grid);
							break;
						
					}
					lowest_area = Math.min(lowest_area, area);
					
				}
				
			}
		}
		
		// Horizontal Slicing
		for(int i = low_x; i < high_x - 1; i++){
			for(int j = i + 1; j < high_x; j++){
				lowest_area = Math.min(lowest_area, findMinArea(low_x, i, low_y, high_y, grid)
													+ findMinArea(i + 1, j, low_y, high_y, grid)
													+ findMinArea(j + 1, high_x, low_y, high_y, grid));
				
				
			}
		}
		
		// Vertical Slicing
		for(int i = low_y; i < high_y - 1; i++){
			for(int j = i + 1; j < high_y; j++){
				lowest_area = Math.min(lowest_area, findMinArea(low_x, high_x, low_y, i, grid)
													+ findMinArea(low_x, high_x, i + 1, j, grid)
													+ findMinArea(low_x, high_x, j + 1, high_y, grid));
												
			}
		}
		
		return (lowest_area == Integer.MAX_VALUE) ? 0 : lowest_area;
		
	}
	
	
	public static void main(String[] args){
		
		int[][] grid = {{1,0,1},{1,1,1}};
		System.out.print(minimumSum(grid));
		
	}
	
}