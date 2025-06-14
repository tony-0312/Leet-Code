/*
Given a circular array nums, find the maximum absolute difference between adjacent elements.

Note: In a circular array, the first and last elements are adjacent.

Example 1:
Input: nums = [1,2,4]

Output: 3
Explanation:
Because nums is circular, nums[0] and nums[2] are adjacent. They have the maximum absolute difference of |4 - 1| = 3.

Example 2:
Input: nums = [-5,-10,-5]

Output: 5
Explanation:
The adjacent elements nums[0] and nums[1] have the maximum absolute difference of |-5 - (-10)| = 5.

Constraints:
2 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

class Max{
	
	static int maxAdjacentDistance(int[] nums){
		int size = nums.length;
		int max = Math.abs(nums[0] - nums[size-1]);
		if(size == 2){
			return max;
		}
		
		for(int i = 1; i < size; i++){
			int currMax = Math.abs(nums[i-1] - nums[i]);
			if(max < currMax){
				max = currMax;
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] nums = {-5,-10,-5};
		System.out.println(maxAdjacentDistance(nums));
	}
}