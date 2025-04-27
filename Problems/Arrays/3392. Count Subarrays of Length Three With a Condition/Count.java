/*
Given an integer array nums, return the number of subarrays of length 3 such that the sum of the 
first and third numbers equals exactly half of the second number.

Example 1:
Input: nums = [1,2,1,4,1]

Output: 1

Explanation:

Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.

Example 2:
Input: nums = [1,1,1]

Output: 0

Explanation:
[1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.

*/

class Count{
	
	static int countSubArrays(int[] nums){
		int size = nums.length;
		int ans = 0;
		
		for(int i = 0; i < size - 2; i++){
			int a = nums[i];
			int b = nums[i+1];
			int c = nums[i+2];
			int temp = (a + c) * 2;
			if(temp == b) ans++;
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int[] nums = {1, 1, 1};
		System.out.println(countSubArrays(nums));
	}
}