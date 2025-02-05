/*
You are given an integer n indicating there are n specialty retail stores. 
There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, 
where quantities[i] represents the number of products of the ith product type.

You need to distribute all products to the retail stores following these rules:

A store can only be given at most one product type but can be given any amount of it.
After distribution, each store will have been given some number of products (possibly 0). 
Let x represent the maximum number of products given to any store. 
You want x to be as small as possible, i.e., you want to minimize the maximum 
number of products that are given to any store.
Return the minimum possible x.

 Example 1:

Input: n = 6, quantities = [11,6]
Output: 3
Explanation: One optimal way is:
- The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
- The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
*/

class MinimizedMaximum{
    static boolean isValidateDistributionCheck(int n, int mid, int[] quantities){
        for(int i = 0; i < quantities.length; i++){
            if(quantities[i] % mid == 0){
                n = n - (quantities[i] / mid);
            }else{
                n = n - ((quantities[i] / mid) + 1);
            }
            
        }
        return n>=0;
    } 
    static int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num : quantities){
            if(num > high) high = num;
        }
        int max_dist = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValidateDistributionCheck(n, mid, quantities)){
                max_dist = Math.min(mid, max_dist);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(max_dist == Integer.MAX_VALUE) return -1;
        return max_dist;
    }
    public static void main(String[] args) {
        int[] nums = {11,6};
        int n = 6;
        int res = minimizedMaximum(n, nums);
        System.out.println(res);
    }
}