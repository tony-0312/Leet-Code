/*

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/

import java.util.List;
import java.util.ArrayList;

class Spiral{
	
	static List<Integer> spiralOrder(int[][] matrix){
		
		List<Integer> ans = new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		
		int top = 0;
		int left = 0;
		int right = col - 1;
		int bottom = row - 1;
		
		while(top <= bottom && left <= right){
			
			for(int i = left; i <= right; i++){
				ans.add(matrix[top][i]);
			}
			
			top++;
			
			for(int i = top; i <= bottom; i++){
				ans.add(matrix[i][right]);
			}
			
			right--;
			
			if(top <= bottom){
				
				for(int i = right; i >= left; i--){
					ans.add(matrix[bottom][i]);
				}
				
				bottom--;
				
			}
			
			if(left <= right){
				
				for(int i = bottom; i >= top; i--){
					ans.add(matrix[i][left]);
				}
				
				left++;
				
			}
			
		}
		
		return ans;
		
	}
	
	public static void main(String[] args){
		
		int[][] matrix = {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12}};
						
		List<Integer> ans = spiralOrder(matrix);
		
		for(int num : ans){
			System.out.print(num + " ");
		}
		
	}
	
}