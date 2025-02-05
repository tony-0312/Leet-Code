/*
 * You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.

 

Example 1:

Input: nums = [2,1,3,5,6], k = 5, multiplier = 2

Output: [8,4,6,5,6]

Explanation:

    Operation	         Result
After operation 1	[2, 2, 3, 5, 6]
After operation 2	[4, 2, 3, 5, 6]
After operation 3	[4, 4, 3, 5, 6]
After operation 4	[4, 4, 6, 5, 6]
After operation 5	[8, 4, 6, 5, 6]
Example 2:

Input: nums = [1,2], k = 3, multiplier = 4

Output: [16,8]

Explanation:

   Operation	        Result
After operation 1	[4, 2]
After operation 2	[4, 8]
After operation 3	[16, 8]
 
 */
class FinalArray{
    static int[] findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        int[] arr = new int[2];
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(min>nums[i]){
                min=nums[i];
                pos = i;
            }
        }
        arr[0] = min;
        arr[1] = pos;
        return arr;
    }
    static int[] getFinalState(int[] nums, int k, int multiplier){
        int[] arr; //to store the minimum number and its position
        int min;
        int pos;
        for (int i = 0; i < k; i++) {
            arr = findMin(nums);
            min = arr[0];
            pos = arr[1];
            min *=multiplier;
            nums[pos] = min;
            for(int num:nums){
                System.out.print(num+" ");
            }
            System.out.println();
        }
        
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int[] ans;
        int k = 5;
        int multiplier = 2;
        ans = getFinalState(nums, k, multiplier);
        for(int num:ans){
            System.out.print(num+" ");
        }
    }
}