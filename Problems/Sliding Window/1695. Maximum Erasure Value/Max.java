/*

You are given an array of positive integers nums and want to erase a subarray containing unique elements. 
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is 
equal to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:
Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 104

*/

import java.util.Set;
import java.util.HashSet;

class Max{
	
	static int maximumUniqueSubarray(int[] nums){
		
		Set<Integer> set = new HashSet<>();
		
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		
		while(i < nums.length && j < nums.length){
			
			if(!set.contains(nums[j])){
				
				sum += nums[j];
				max = Math.max(sum, max);
				set.add(nums[j++]);
				
			}else{
				sum -= nums[i];
				set.remove(nums[i++]);
			}
			
		}
		
		return max;
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {9,7,4,3,2,4,5,6,4,2,9};
		System.out.print(maximumUniqueSubarray(nums));
 		
	}
	
}