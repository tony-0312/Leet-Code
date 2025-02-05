/*
    Given an integer array nums sorted in non-decreasing order,
     remove the duplicates in-place such that each unique element appears only once. 
     The relative order of the elements should be kept the same. 
     Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, 
    to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements 
    in the order they were present in nums initially. The remaining elements of nums 
    are not important as well as the size of nums.
    Return k.

    Example:

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums 
    being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).
 */
class RemoveDuplicates{
    static int removeDuplicates(int[] nums){
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) nums[k++] = nums[i];
        }
        return k; 
    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(arr);
        System.out.println(res);
    }
}