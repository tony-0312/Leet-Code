/*
 * Given an integer array nums, rotate the array to the right by k steps, 
 * where k is non-negative.
 
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

class RotateArray{
    static void reversal(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int n = arr.length;
        int k = 3;
        System.out.println(k);
        k %=n;
        reversal(arr, 0, n-1);
        reversal(arr, 0, k-1);
        reversal(arr, k, n-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
        
    }
}