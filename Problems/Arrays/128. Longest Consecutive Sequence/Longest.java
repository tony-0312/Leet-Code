/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Longest{
	
	static int longestConsecutive(int[] nums){
		if(nums.length == 0) return 0;
		
		int ans = 1;
		
		Set<Integer> set = new HashSet<>();
		
		for(int num : nums){
			set.add(num);
		}
		
		for(int it : set){
			if(!set.contains(it - 1)){
				int count = 1;
				int x = it;
				while(set.contains(x+1)){
					x++;
					count++;
				}
				ans = Math.max(ans, count);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		
		int[] nums = {1,0,1,2};
		System.out.println(longestConsecutive(nums));
		
	}
	
}