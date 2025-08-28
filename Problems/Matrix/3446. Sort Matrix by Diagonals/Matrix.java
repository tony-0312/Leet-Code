/* 

You are given an n x n square matrix of integers grid. Return the matrix such that:

The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
The diagonals in the top-right triangle are sorted in non-decreasing order.

Example 1:
Input: grid = [[1,7,3],[9,8,2],[4,5,6]]

Output: [[8,2,3],[9,6,7],[4,5,1]]

Explanation:
The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:

[1, 8, 6] becomes [8, 6, 1].
[9, 5] and [4] remain unchanged.
The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:

[7, 2] becomes [2, 7].
[3] remains unchanged.

Example 2:
Input: grid = [[0,1],[1,2]]

Output: [[2,1],[1,0]]

Explanation:
The diagonals with a black arrow must be non-increasing, so [0, 2] is changed to [2, 0]. 
The other diagonals are already in the correct order.

Example 3:
Input: grid = [[1]]

Output: [[1]]

Explanation:
Diagonals with exactly one element are already in order, so no changes are needed.

Constraints:
grid.length == grid[i].length == n
1 <= n <= 10
-105 <= grid[i][j] <= 105

*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Collections;

class Matrix{
	
	static void sortMatrix(int[][] grid){
		
		Map<Integer, PriorityQueue<Integer>> diagonalMap = new HashMap<>();
		int rows = grid.length;
		int cols = grid[0].length;
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				
				int key = i - j;
				diagonalMap.putIfAbsent(key, key < 0 ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder()));
				diagonalMap.get(key).offer(grid[i][j]);
				
			}
		}
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				
				int key = i - j;
				grid[i][j] = diagonalMap.get(key).poll();
				
			}
		}
		
		
	}
	
	public static void main(String[] args){
		
		int[][] grid = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
		sortMatrix(grid);
		
		for(int[] arr : grid){
			for(int num : arr){
				System.out.print(num + " ");
			}
			System.out.println();
		}
		
	}
	
}