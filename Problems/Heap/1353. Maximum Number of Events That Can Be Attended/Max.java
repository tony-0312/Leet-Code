/*
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startDayi <= d <= endDayi. You can only attend one event at any time d.

Return the maximum number of events you can attend.

Example 1:
Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

Example 2:
Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4

Constraints:
1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105

*/

import java.util.Arrays;
import java.util.PriorityQueue;

class Max{
	
	static int maxEvents(int[][] events){
		
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		
		int day = 0, index = 0, n = events.length, result = 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		while(!pq.isEmpty() || index < n){
			
			if(pq.isEmpty()){
				day = events[index][0];
			}
			
			while(index < n && events[index][0] <= day){
				pq.offer(events[index][1]);
				index++;
			}
			
			pq.poll();
			result++;
			day++;
			
			while(!pq.isEmpty() && pq.peek() < day){
				pq.poll();
			}
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args){
		
		int[][] events = {{1,2},{2,3},{3,4}};
		System.out.print(maxEvents(events));
		
	}
	
}