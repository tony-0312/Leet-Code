/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 
Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
*/

class Move{
	
	static int[] moveZeroes(int[] nums){
		int j = -1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				j = i;
				break;
			}
		}
		if(j == -1 || j == nums.length - 1) return nums;
		
		for(int i = j + 1; i < nums.length; i++){
			if(nums[i] != 0){
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {0, 1, 0, 3, 12};
		int[] ans = moveZeroes(nums);
	}
	
}