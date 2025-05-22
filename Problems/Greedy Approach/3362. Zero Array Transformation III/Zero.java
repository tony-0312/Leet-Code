/*
You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most 1.
The amount by which the value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the maximum number of elements that can be removed from queries, such that nums can still be converted 
to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.

Example 1:
Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]

Output: 1

Explanation:

After removing queries[2], nums can still be converted to a zero array.

Using queries[0], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
Using queries[1], decrement nums[0] and nums[2] by 1 and nums[1] by 0.

Example 2:
Input: nums = [1,1,1,1], queries = [[1,3],[0,2],[1,3],[1,2]]

Output: 2

Explanation:

We can remove queries[2] and queries[3].

Example 3:
Input: nums = [1,2,3,4], queries = [[0,3]]

Output: -1

Explanation:

nums cannot be converted to a zero array even after using all the queries.

*/

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;

class Zero{
	
	static int maxRemoval(int[] nums, int[][] queries){
		
		int size = nums.length;
		PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
		PriorityQueue<Integer> usedQuery = new PriorityQueue<>(); // Min Heap
		
		Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
		
		int queryPos = 0;
		int appliedCount = 0;
		
		for(int i = 0; i < size; i++){
			
			while(queryPos < queries.length && queries[queryPos][0] == i){
				availableQuery.offer(queries[queryPos][1]);
				queryPos++;
			}
			
			nums[i] -= usedQuery.size();
			
			while(nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i){
				int end = availableQuery.poll();
				usedQuery.offer(end);
				nums[i]--;
				appliedCount++;
			}
			
			if(nums[i] > 0) return -1;
			
			while(!usedQuery.isEmpty() && usedQuery.peek() == i){
				usedQuery.poll();
			}
			
		}
		
		return queries.length - appliedCount;
		
	}
	
	public static void main(String[] args){
		int[] nums = {2,0,2};
		int[][] queries = {{0,2},{0,2},{1,1}};
		System.out.println(maxRemoval(nums, queries));
	}
	
}