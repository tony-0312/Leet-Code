/*

You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2
representing the cost of fruit in each basket. You want to make both baskets equal. To do so, you can use the following 
operation as many times as you want:

Choose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
The cost of the swap is min(basket1[i], basket2[j]).
Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.

Return the minimum cost to make both the baskets equal or -1 if impossible.

Example 1:
Input: basket1 = [4,2,2,2], basket2 = [1,4,1,2]
Output: 1
Explanation: Swap index 1 of basket1 with index 0 of basket2, which has cost 1. Now basket1 = [4,1,2,2] and basket2 = [2,4,1,2]. Rearranging both the arrays makes them equal.

Example 2:
Input: basket1 = [2,3,4,1], basket2 = [3,2,5,1]
Output: -1
Explanation: It can be shown that it is impossible to make both the baskets equal.

Constraints:
basket1.length == basket2.length
1 <= basket1.length <= 105
1 <= basket1[i], basket2[i] <= 109

*/

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Rearrange{
	
	static long minCost(int[] basket1, int[] basket2){
		
		int n = basket1.length;
		Map<Integer, Integer> balance = new TreeMap<>();
		int minVal = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++){
			balance.put(basket1[i], balance.getOrDefault(basket1[i], 0) + 1);
			balance.put(basket2[i], balance.getOrDefault(basket2[i], 0) - 1);
			minVal = Math.min(minVal, Math.min(basket1[i], basket2[i]));
		}
		
		List<Integer> transfers = new ArrayList<>();
		
		for(Map.Entry<Integer, Integer> entrySet : balance.entrySet()){
			int val = entrySet.getKey();
			int freq = entrySet.getValue();
			if((freq & 1) != 0){
				return - 1;
			}
			for(int k = 0; k < Math.abs(freq) / 2; k++){
				transfers.add(val);
			}
		}
		
		Collections.sort(transfers);
		
		long cost = 0;
		
		int size = transfers.size();
		
		for(int i = 0; i < size / 2; i++){
			cost += Math.min(transfers.get(i), 2 * minVal);
		}
		
		return cost;
		
	}
	
	public static void main(String[] args){
		
		int[] basket1 = {4,2,2,2};
		int[] basket2 = {1,4,1,2};
		System.out.print(minCost(basket1, basket2));
		
	}
	
}