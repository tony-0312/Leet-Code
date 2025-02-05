/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 */

 class MajorityElement{
    
    static int majorityElement(int[] nums){
        int count = 0;
        int ans = 0;
        for(int num:nums){
            if(count == 0) ans = num;
            if(num == ans) count++;
            else count--; 
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int res = majorityElement(nums);    
        System.out.println("Majority element from the given array is "+res);
    }
 }