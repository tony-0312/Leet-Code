/*
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing 
the order of the remaining elements.

Example 1:
Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.

Example 2:
Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.

Example 3:
Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].

Constraints:
1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length

*/

import java.util.Arrays;

class Largest{
	
	static int[] maxSubSequence(int[] nums, int k){
		int[][] sortArr = new int[nums.length][2];
		int[] ans = new int[k];
		for(int i = 0; i < nums.length; i++){
			sortArr[i] = new int[]{nums[i], i};
		}
		
		Arrays.sort(sortArr, (a, b) -> a[0] - b[0]);
			
		Arrays.sort(sortArr, nums.length-k, nums.length, (a, b) -> a[1] - b[1]);
		
		for(int i = 0; i < k; i++){
			ans[i] = sortArr[nums.length-k+i][0];
		}
		
		return ans;
		
	}
	
	public static void main(String[] args){
		int[] nums = {2,1,3,3};
		int k = 2;
		int[] ans = maxSubSequence(nums, k);
		
		for(int num : ans){
			System.out.print(num + " ");
		}
		
	}
	
}