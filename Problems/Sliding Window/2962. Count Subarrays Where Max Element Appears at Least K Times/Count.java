/*
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

Example 1:
Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], 
[2,3,3] and [3,3].

Example 2:
Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
*/

import java.util.HashMap;
import java.util.Map;

class Count{
	
	static long countSubArrays(int[] nums, int k){
		if(nums.length == 0) return 0;
		if(nums.length < k) return 0;
		if(nums.length == k) return k;
		
		int max = Integer.MIN_VALUE;
		long totalSubArrays = 0;
		int left = 0, right = 0;
		
		for(int num : nums){
			if(max < num){
				max = num;
			}
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		while(right < nums.length){
			map.put(nums[right], map.getOrDefault(nums[right], 0)+1);
			right++;
			
			while(map.get(max) != null && (map.get(max) > k || (map.get(max) == k && nums[left] != max))){
				map.put(nums[left], map.get(nums[left]) - 1);
				left++;	
			}
			if(map.get(max) != null && map.get(max) == k){
				totalSubArrays += left + 1;
			}
		}
		return totalSubArrays;
	}
	
	public static void main(String[] args){
		int[] nums = {1,4,2,1};
		int k = 3;
		System.out.print(countSubArrays(nums, k));
	}
}