/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and 
choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve
 any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
class BestStock{
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        // int n = prices.length-1;
        // int min = Integer.MAX_VALUE;
        // int pos = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     if(i!=n && prices[i] < min){
        //         min = prices[i];
        //         pos = i;
        //     }
        // }
        // int max = Integer.MIN_VALUE;        
        // for (int i = pos; i < prices.length; i++) {
        //     if(prices[i] > max){
        //         max = prices[i];
        //     }
        // }
        // if(max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) System.out.println(0);
        // System.out.println(max-min);

        int ans = 0;
        int mi = prices[0];
        for(int v : prices){
            ans = Math.max(ans, v - mi);
            mi = Math.min(mi,v);
        }

        System.out.println(ans);

    }
}