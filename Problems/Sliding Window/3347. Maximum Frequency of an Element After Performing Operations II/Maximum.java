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

Adding 0 to nums[1], after which nums becomes [1, 4, 5].
Adding -1 to nums[2], after which nums becomes [1, 4, 4].

Example 2:
Input: nums = [5,11,20,20], k = 5, numOperations = 1

Output: 2

Explanation:
We can achieve a maximum frequency of two by:

Adding 0 to nums[1].

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
0 <= k <= 109
0 <= numOperations <= nums.length

*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Maximum{
	
	static int maxFrequency(int[] nums, int k, int numOperations){
		
		int n = nums.length;
		
		if(n == 0)
			return 0;
		
		Arrays.sort(nums);
		
		Map<Long, Integer> freq = new HashMap<>();
		for(int num : nums){
			
			freq.put((long)num, freq.getOrDefault((long)num, 0) + 1);
			
		}
		
		int ans = 1;
		
		for(Map.Entry<Long, Integer> entrySet : freq.entrySet()){
			
			long v = entrySet.getKey();
			int already = entrySet.getValue();
			
			long lowVal = v - k;
			long highVal = v + k;
			int L = lowerBound(nums, lowVal);
			int R = upperBound(nums, highVal);
			int totalInRange = R - L;
			int need = totalInRange - already;
			int canFix = Math.min(need, numOperations);
			ans = Math.max(ans, already + canFix);
			
		}
		
		int l = 0;
		for(int r = 0; r < n; r++){
			
			while(l <= r && (long)nums[r] - nums[l] > 2L * k)
				l++;
			int w = r - l + 1;
			ans = Math.max(ans, Math.min(w, numOperations));
			
		}
		
		return ans;
		
	}
	
	static int lowerBound(int[] arr, long target){
		
		int l = 0;
		int r = arr.length;
		
		while(l < r){
			
			int mid = (l + r) >> 1;
			if((long)arr[mid] < target)
				l = mid + 1;
			else
				r = mid;
			
		}
		
		return l;
		
	}
	
	static int upperBound(int[] arr, long target){
		
		int l = 0;
		int r = arr.length;
		
		while(l < r){
			
			int mid = (l + r) >> 1;
			if((long)arr[mid] <= target)
				l = mid + 1;
			else
				r = mid;
			
		}
		
		return l;
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {1,4,5};
		int numOperations = 2;
		int k = 1;
		System.out.print(maxFrequency(nums, k, numOperations));
		
	}
	
}