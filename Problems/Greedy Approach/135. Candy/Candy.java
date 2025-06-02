/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
*/

import java.util.Arrays;

class Candy{

    static int candy(int[] ratings){
        int n = ratings.length;
        int cnt = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i < n; i++){
            if(ratings [i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        for(int i = n - 1; i >= 1; i--){
            if(ratings[i-1] > ratings[i]){
                candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
            }
            cnt += candies[i-1];
        }
        return cnt + candies[n-1];
    }

    public static void main(String[] args){
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }
}
