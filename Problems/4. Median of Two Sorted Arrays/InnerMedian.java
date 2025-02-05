/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

class InnerMedian{
    static double findMedianOfTwoSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return findMedianOfTwoSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int imin = 0;
        int imax = m;
        int halfLen = (m + n + 1)/2;
        while(imin <= imax){
            int i = (imin + imax)/2;
            int j = halfLen - i;
            // if i is smaller
            if(i < m && nums1[i] < nums2[j-1]){
                imin = i + 1;
            }
            // if i is bigger
            else if(i > 0 && nums1[i-1] > nums2[j]){
                imax = i - 1;
            }
            // if i is perfect
            else{
                int maxLeft;
                if(i==0) maxLeft = nums2[j-1];
                else if(j==0) maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if((m+n)%2 == 1) return maxLeft; 


                int minRight;
                if(i==m) minRight = nums2[j];
                else if(j==n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);

                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,7};
        System.out.println(findMedianOfTwoSortedArrays(nums1, nums2));

        // int[] nums3 = {1,2};
        // int[] nums4 = {3,4};
        // System.out.println(findMedianOfTwoSortedArrays(nums3, nums4));

    }
}