/*

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 
Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

*/

import java.util.Map;
import java.util.HashMap;

class Sum{
	
	static int subarraySum(int[] nums, int k){
		
		Map<Integer, Integer> map = new HashMap<>();
		int prefixSum = 0;
		int count = 0;
		
		map.put(0, 1);
		
		for(int i = 0; i < nums.length; i++){
			
			prefixSum += nums[i];
			int remove = prefixSum - k;
			
			count += map.getOrDefault(remove, 0);
			
			map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
			
		}
		
		return count;
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {3, 1, 2, 4};
		int k = 6;
		
		System.out.print(subarraySum(nums, k));
		
	}
	
}