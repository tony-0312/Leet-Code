/*
 * In the town of Digitville, there was a list of numbers called nums containing 
 * integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, 
 * however, two mischievous numbers sneaked in an additional time, making the list longer than usual.

As the town detective, your task is to find these two sneaky numbers. 
Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.

 

Example 1:

Input: nums = [0,1,1,0]

Output: [0,1]

Explanation:

The numbers 0 and 1 each appear twice in the array.

Example 2:

Input: nums = [0,3,2,1,3,2]

Output: [2,3]

Explanation:

The numbers 2 and 3 each appear twice in the array.

Example 3:

Input: nums = [7,1,5,4,3,4,6,0,9,5,8,2]

Output: [4,5]

Explanation:

The numbers 4 and 5 each appear twice in the array.
 */

import java.util.HashMap;
import java.util.Map;

class TwoSneaky{
    static int[] findTwoSneakyNums(int[] nums){
        int[] ans = new int[2];
        int index = 0;
        HashMap<Integer, Integer> countNums = new HashMap<>();
        for(int num : nums){
            countNums.put(num, countNums.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entrySet : countNums.entrySet()){
            if(entrySet.getValue() == 2){
                ans[index++] = entrySet.getKey();
            }
            if(index == 2) break;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {7,1,5,4,3,4,6,0,9,5,8,2};
        int[] ans = findTwoSneakyNums(nums);
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}