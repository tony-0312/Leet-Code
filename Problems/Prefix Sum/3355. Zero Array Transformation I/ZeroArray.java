/*
You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

Select a subset of indices within the range [li, ri] in nums.
Decrement the values at the selected indices by 1.
A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, 
otherwise return false.

Example 1:
Input: nums = [1,0,1], queries = [[0,2]]

Output: true

Explanation:

For i = 0:
Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
The array will become [0, 0, 0], which is a Zero Array.

Example 2:
Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]

Output: false

Explanation:

For i = 0:
Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
The array will become [4, 2, 1, 0].
For i = 1:
Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
The array will become [3, 1, 0, 0], which is not a Zero Array.
*/
class ZeroArray{
	
	static boolean isZeroArray(int[] nums, int[][] queries){
		int[] differArray = new int[nums.length+1];
		for(int i = 0; i < queries.length; i++){
			int left = queries[i][0];
			int right = queries[i][1];
            
			differArray[left] += 1;
			
			differArray[right+1] -= 1;
		}
		
		
		for(int i = 1; i < differArray.length; i++){
			differArray[i] = differArray[i] + differArray[i-1];
		}
		for(int i = 0; i < nums.length; i++){
			if(differArray[i] < nums[i]) return false;
		}
        return true;
	
	}
	
	public static void main(String[] args){
		int[] nums = {1, 0, 1};
		int[][] queries = {{0,2}};
		System.out.println(isZeroArray(nums, queries));
	}
	
}