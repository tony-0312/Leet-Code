/*
Given an integer array nums, return true if you can partition the array into two subsets such 
that the sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

import java.util.Set;
import java.util.HashSet;

class Partition{
	
	static boolean canPartition(int[] nums){
		int sum = 0;
		Set<Integer> dp = new HashSet<>();
		dp.add(0);
		int size = nums.length;
		
		for(int num : nums){
			sum += num;
		}
		
		if(sum % 2 != 0) return false;
		
		int targetSum = sum / 2;
		
		for(int i = size - 1; i >= 0; i--){
			Set<Integer> nextDP = new HashSet<>();
			for(int num : dp){
				if(num + nums[i] == targetSum) return true;
				nextDP.add(num + nums[i]);
				nextDP.add(num);
			}
			dp = nextDP;
		}
		
		return dp.contains(targetSum) ? true : false;		
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		System.out.println(canPartition(nums));
	}
}