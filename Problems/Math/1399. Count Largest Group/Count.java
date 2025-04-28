/*
You are given an integer n.

We need to group the numbers from 1 to n according to the sum of its digits. For example, the numbers 14 
and 5 belong to the same group, whereas 13 and 3 belong to different groups.

Return the number of groups that have the largest size, i.e. the maximum number of elements.
 
Example 1:
Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.

Example 2:
Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.
*/

class Count{
	
	static int countLargestGroup(int n){
		if(n < 10) return n;
		int[] sumFreq = new int[40];// Because constraint n is maximum upto 9999 so 9 * 4 = 36. So 40 is safe
		int ans = 0;
		int maxGroupSize = 0;
		
		for(int i = 1; i <= n; i++){
			int sumDigits = 0;
			
			for(int temp = i; temp > 0; temp /= 10){
				sumDigits += temp % 10;
			}
			
			sumFreq[sumDigits]++;
			
			if(maxGroupSize < sumFreq[sumDigits]){
				maxGroupSize = sumFreq[sumDigits];
				ans = 1;
			}else if(maxGroupSize == sumFreq[sumDigits]){
				ans++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		int n = 5;
		System.out.print(countLargestGroup(n));
	}
}