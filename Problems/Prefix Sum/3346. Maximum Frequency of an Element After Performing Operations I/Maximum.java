/*

You are given an integer array nums and two integers k and numOperations.

You must perform an operation numOperations times on nums, where in each operation you:

Select an index i that was not selected in any previous operations.
Add an integer in the range [-k, k] to nums[i].
Return the maximum possible frequency of any element in nums after performing the operations.

Example 1:
Input: nums = [1,4,5], k = 1, numOperations = 2

Output: 2

Explanation:
We can achieve a maximum frequency of two by:

Adding 0 to nums[1]. nums becomes [1, 4, 5].
Adding -1 to nums[2]. nums becomes [1, 4, 4].

Example 2:
Input: nums = [5,11,20,20], k = 5, numOperations = 1

Output: 2

Explanation:
We can achieve a maximum frequency of two by:

Adding 0 to nums[1].

1 <= nums.length <= 105
1 <= nums[i] <= 105
0 <= k <= 105
0 <= numOperations <= nums.length

*/

import java.util.Arrays;

class Maximum{
	
	static int maxFrequency(int[] nums, int k, int numOperations){
		
		int maxVal = Arrays.stream(nums).max().getAsInt() + k + 2;
		int[] count = new int[maxVal];
		
		for(int num : nums){
			
			count[num]++;
			
		}
		
		for(int i = 1; i < maxVal; i++){
			count[i] += count[i-1];
		}
		
		int res = 0;
		
		for(int i = 0; i < maxVal; i++){
			
			int left = Math.max(0, i - k);
			int right = Math.min(maxVal - 1, i + k);
			int total = count[right] - (left > 0 ? count[left - 1] : 0);
			int freq = count[i] - (i > 0 ? count[i - 1] : 0);
			res = Math.max(res, freq + Math.min(numOperations, total - freq));
			
		}
		
		return res;
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {1,4,5};
		int numOperations = 2;
		int k = 1;
		System.out.print(maxFrequency(nums, k, numOperations));
		
	}
	
}