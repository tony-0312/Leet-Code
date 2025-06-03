/*
You are given an integer array nums.

You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, 
select a subarray of nums such that:

All elements in the subarray are unique.
The sum of the elements in the subarray is maximized.
Return the maximum sum of such a subarray.

Example 1:
Input: nums = [1,2,3,4,5]
Output: 15
Explanation:
Select the entire array without deleting any element to obtain the maximum sum.

Example 2:
Input: nums = [1,1,0,1,1]
Output: 1
Explanation:
Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

Example 3:
Input: nums = [1,2,-1,-2,1,0,-1]
Output: 3
Explanation:
Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.
*/

import java.util.Set;
import java.util.HashSet;

class Max{

    static int maxSum(int[] nums){
        int totalSum = 0;
        Set<Integer> set = new HashSet<>();
        int maxNeg = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                set.add(nums[i]);
            else
                maxNeg = Math.max(maxNeg, nums[i]);
        }

        for(int num : set){
            totalSum += num;
        }

        if(set.size() > 0){
            return totalSum;
        else
            return maxNeg;
    }

    public static void main(String[] args){
        int[] nums = {1,2,-1,-2,1,0,-1};
        System.out.println(maxSum(nums));
    }
}
