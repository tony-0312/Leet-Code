/*

You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.

You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of n 
non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the longest 
continuous period of free time during the event.

The relative order of all the meetings should stay the same and they should remain non-overlapping.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event.

Example 1:
Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:
Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:
Input: eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]

Output: 6

Explanation:
Reschedule the meeting at [2, 4] to [1, 3], leaving no meetings during the time [3, 9].

Example 3:
Input: eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.

Constraints:
1 <= eventTime <= 109
n == startTime.length == endTime.length
2 <= n <= 105
1 <= k <= n
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].

*/

import java.util.Deque;
import java.util.ArrayDeque;

class Max{
	
	static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime){
		
		if(eventTime > endTime[endTime.length - 1]){
			
			int[] newStartTime = new int[startTime.length + 1];
			int[] newEndTime = new int[endTime.length + 1];
			System.arraycopy(startTime, 0, newStartTime, 0, startTime.length);
			System.arraycopy(endTime, 0, newEndTime, 0, endTime.length);
			newStartTime[startTime.length] = eventTime;
			newEndTime[endTime.length] = eventTime;
			startTime = newStartTime;
			endTime = newEndTime;
			
		}
		
		int size = startTime.length;
		int pos = 0;
		int win_sum = 0;
		int max_sum = 0;
		int last_end = 0;
		
		Deque<Integer> dq = new ArrayDeque<>();

		while(pos < size){
			
			win_sum += startTime[pos] - last_end;
			dq.addLast(startTime[pos] - last_end);
			max_sum = Math.max(max_sum, win_sum);
			
			if(dq.size() > k){
				
				win_sum -= dq.removeFirst();
				
			}
			
			last_end = endTime[pos];
			pos++;
			
		}
		
		return max_sum;
		
	}
	
	public static void main(String[] args){
		
		int eventTime = 5;
		int k = 1;
		int[] startTime = {1, 3};
		int[] endTime = {2, 5};
		System.out.print(maxFreeTime(eventTime, k, startTime, endTime));
		
	}
	
}