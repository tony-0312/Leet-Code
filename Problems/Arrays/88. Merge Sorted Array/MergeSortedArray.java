/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
 * representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
class MergeSortedArray{
    static void merge(int[] nums1, int m, int[] nums2, int n){
       for(int i = m-1, j = n-1, k = m+n-1; j>=0; k--){
        nums1[k] = i>=0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        
       }
       for(int num : nums1){
        System.out.println(num);
    } 
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 0;
        for(int num : nums1){
            if(num != 0) m++;
        }
        System.out.println(m);
        merge(nums1, m, nums2, nums2.length);
    }
}