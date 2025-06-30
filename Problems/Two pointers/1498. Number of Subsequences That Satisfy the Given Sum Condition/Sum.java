/*
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it 
is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

Example 1:
Input: nums = [3,5,6,7], target = 9
Output: 4
Explanation: There are 4 subsequences that satisfy the condition.
[3] -> Min value + max value <= target (3 + 3 <= 9)
[3,5] -> (3 + 5 <= 9)
[3,5,6] -> (3 + 6 <= 9)
[3,6] -> (3 + 6 <= 9)

Example 2:
Input: nums = [3,3,6,8], target = 10
Output: 6
Explanation: There are 6 subsequences that satisfy the condition. (nums can have repeated numbers).
[3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]

Example 3:
Input: nums = [2,3,3,4,6,7], target = 12
Output: 61
Explanation: There are 63 non-empty subsequences, two of them do not satisfy the condition ([6,7], [7]).
Number of valid subsequences (63 - 2 = 61).

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= target <= 106

*/

import java.util.Arrays;

class Sum{
	static final int MOD = (int)1e9 + 7;
	
	static void precomputePowOfTwo(int[] powOfTwo, int size){
		
		powOfTwo[0] = 1;
		
		for(int i = 1; i < size; i++){
			powOfTwo[i] = (int)((powOfTwo[i - 1] * 2L) % MOD);
		}
		
	}
	
	
	static int numSubSeq(int[] nums, int target){
		int size = nums.length;
		int[] powOfTwo = new int[size];
		precomputePowOfTwo(powOfTwo, size);
		Arrays.sort(nums);
		int subSeq = 0;
		
		int left = 0;
		int right = size - 1;
		
		while(left <= right){
			if(nums[left] + nums[right] > target){
				right--;
			}else{
				subSeq = (subSeq + powOfTwo[right - left]) % MOD;
				left++;
			}
		}
		
		return subSeq;		
		
	}
	
	public static void main(String[] args){
		int[] nums = {3,5,6,7};
		int target = 9;
		System.out.println(numSubSeq(nums, target));
	}
	
}