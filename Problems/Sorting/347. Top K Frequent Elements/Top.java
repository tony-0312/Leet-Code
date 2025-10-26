/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:
Input: nums = [1], k = 1

Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class Top{
	
	static int[] topKFrequent(int[] nums, int k){
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[nums.length + 1];

		for(int num : nums){
			
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
			
		}
		
		for(int key : freqMap.keySet()){
			
			int freq = freqMap.get(key);
			if(buckets[freq] == null){
				
				buckets[freq] = new ArrayList<>();
				
			}
			buckets[freq].add(key);
			
		}
		
		int[] res = new int[k];
		int idx = 0;
		for(int pos = buckets.length - 1; pos >= 0 && idx < k; pos--){
			
			if(buckets[pos] != null){
				for(int num : buckets[pos]){
					res[idx++] = num;
				}
			}
			
		}
		
		return res;
		
	}
	
	public static void main(String[] args){
		
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		int[] res = topKFrequent(nums, k);
		for(int num : res){
			
			System.out.print(num + " ");
			
		}
		
	}
	
}