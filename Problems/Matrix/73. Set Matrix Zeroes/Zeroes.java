/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

class Zeroes{
	
	static void setZeroes(int[][] matrix){
		
		int row = matrix.length;
		int col = matrix[0].length;
		/* 
		// Naive Approach
		int[][] dummyArr = new int[row][col];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(matrix[i][j] == 0){
					for(int x = 0; x < col; x++){
						dummyArr[i][x] = -1;
					}
					for(int y = 0; y < row; y++){
						dummyArr[y][j] = -1;
					}
				}
			}
		}
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				if(dummyArr[i][j] == -1){
					matrix[i][j] = 0;
				}
			}
		}
		*/
		
		// Optimized Approach
		boolean zero_row = false;
		boolean zero_col = false;
		
		// First Step
		for(int i = 0; i < row; i++){
			if(matrix[i][0] == 0){
				zero_col= true;
				break;
			}
		}
		
		for(int i = 0; i < col; i++){
			if(matrix[0][i] == 0){
				zero_row= true;
				break;
			}
		}
		
		// Second Step
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		
		// Third Step
		for(int i = 1; i < col; i++){
			if(matrix[0][i] == 0){
				for(int j = 1; j < row; j++){
					matrix[j][i] = 0;
				}
			}
		}
		
		for(int i = 1; i < row; i++){
			if(matrix[i][0] == 0){
				for(int j = 1; j < col; j++){
					matrix[i][j] = 0;
				}
			}
		}
		
		// Final Step
		if(zero_col){
			for(int i = 0; i < row; i++){
				matrix[i][0] = 0;
			}
		}
		if(zero_row){
			for(int i = 0; i < col; i++){
				matrix[0][i] = 0;
			}
		}
		
		// Printing the result
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(matrix);
	}
	
}