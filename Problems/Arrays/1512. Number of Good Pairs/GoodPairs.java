/*
 * Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0
 */
import java.util.HashMap;
import java.util.Map;

class GoodPairs{
    static int findGoodPairs(int[] nums){
        int count = 0;
        HashMap<Integer, Integer> countNums = new HashMap<>();
        for(int num : nums){
            if(countNums.containsKey(num)){
                countNums.put(num, countNums.get(num)+1);
            }else{
                countNums.put(num, 1);
            }
        }

        for(Map.Entry entrySet : countNums.entrySet()){
            int value = (int)entrySet.getValue();
            count = count + (value*(value-1))/2;
        }
        return count;
    } 
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(findGoodPairs(nums));
    }
}