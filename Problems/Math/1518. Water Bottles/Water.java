/*

There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles 
from the market with one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

Example 1:
Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.

Example 2:
Input: numBottles = 15, numExchange = 4
Output: 19
Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
Number of water bottles you can drink: 15 + 3 + 1 = 19.

Constraints:
1 <= numBottles <= 100
2 <= numExchange <= 100

Explanation for O(1) solution:

Key observation: A full bottle of water = A empty bottle + One (bottle) unit of water.

e.g., for test case: 9, 3:
3 empty bottles can exchange 1 full bottle of water implies 3 empty bottles exchange 1 empty bottle + 1 (bottle) 
unit of water, which in turn means (3 - 1) = 2 empty bottles can exchange 1 (bottle) unit of water.

Further more, if you only have 2 empty bottles remaining(the edge case), you can NOT exchange it for 1 (bottle) unit of water.

Substitue the number 3 above by numExchange, we get an important conclusion:
(numExchange - 1) empty bottles can exchange 1 (bottle) unit of water, unless you have only numExchange left.

When we meet edge case we need to minus 1 additionally in the numerator (numBottles - 1)/ (numExchange - 1) to avoid having only 
numExchange left but unable to exchange 1 bottle of water
Note: Under (numExchange - 1) * n condition , we call it edge case

*/

class Water{
	
	static int numWaterBottles(int numBottles, int numExchange){
		
		return numBottles + (numBottles - 1)/(numExchange - 1);
		
	}
	
	public static void main(String[] args){
		
		int numBottles  = 15;
		int numExchange  = 4;
		System.out.print(numWaterBottles(numBottles, numExchange));
		
	}
	
}