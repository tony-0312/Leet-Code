/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same 
color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
*/

class Sort{
	
	static void sortColors(int[] nums){
		int left = 0, mid = 0;
		int right = nums.length - 1;
		
		while(mid<= right){
			
			if(nums[mid] == 0){
				int temp = nums[mid];
				nums[mid] = nums[left];
				nums[left] = temp;
				left++;
				mid++;
			}else if(nums[mid] == 2){
				int temp = nums[mid];
				nums[mid] = nums[right];
				nums[right] = temp;
				right--;
			}else{
				mid++;
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = {2,0,2,1,1,0};
		sortColors(nums);
		for(int num : nums){
			System.out.print(num + " ");
		}
	}
}