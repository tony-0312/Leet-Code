/*
You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

Example 1:
Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].

Example 2:
Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.
*/

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Count{
	
	static int countCompleteSubArrays(int[] nums){
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : nums){
			set.add(num);
		}
		int uniqueCount = set.size();
		int left = 0;
		int right = 0;
		int length = nums.length;
		int ans = 0;
		
		while(left < length){
			while(right < length && map.size() < uniqueCount){
				map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
				right++;
			}
			
			if(map.size() < uniqueCount) break;
			
			ans += length - right + 1;
			
			map.put(nums[left], map.get(nums[left]) - 1);
			if(map.get(nums[left]) == 0){
				map.remove(nums[left]);
			}
			left++;
		}
		return ans;
	}
	
	public static void main(String[] args){
		int[] nums = {5, 5, 5, 5};
		System.out.println(countCompleteSubArrays(nums));
	}
}