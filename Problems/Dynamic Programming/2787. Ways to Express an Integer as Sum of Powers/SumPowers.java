/*
Given two positive integers n and x.
Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, 
the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.

Since the result can be very large, return it modulo 109 + 7.

For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

Example 1:
Input: n = 10, x = 2
Output: 1
Explanation: We can express n as the following: n = 32 + 12 = 10.
It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.

Example 2:
Input: n = 4, x = 1
Output: 2
Explanation: We can express n in the following ways:
- n = 41 = 4.
- n = 31 + 11 = 4.

Constraints:
1 <= n <= 300
1 <= x <= 5

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class SumPowers{
	private static final int MOD = 1_000_000_007;
	
	static long powerWithLimit(int a, int b, int limit){
		
		long res = 1;
		
		for(int i = 0; i < b; i++){
			
			res *= a;
			if(res > limit)
				return (long)limit + 1;
			
		}
		
		return res;
		
	}
	
	static int numberOfWays(int n, int x){
		
		List<Integer> powers = new ArrayList<>();
		
		for(int i = 1; i <= n; i++){
			
			long p = powerWithLimit(i, x, n);
			if(p > n)
				break;
			powers.add((int)p);
			
		}
		
		int p_count = powers.size();
		int[][] mem = new int[p_count][n+1];
		
		for(int i = 0; i < p_count; i++){
			Arrays.fill(mem[i], -1);
		}
		
		return findWays(0, n, powers, mem);
		
	}
	
	static int findWays(int pos, int target, List<Integer> powers, int[][] mem){
		
		if(target == 0)
			return 1;
		
		if(pos == powers.size() || target < 0)
			return 0;
		
		if(mem[pos][target] != -1)
			return mem[pos][target];
		
		int exclude = findWays(pos + 1, target, powers, mem);
		int include = 0;
		int val = powers.get(pos);
		if(target - val >= 0)
			include = findWays(pos + 1, target - val, powers, mem);
		
		mem[pos][target] = (int)((exclude + (long)include) % MOD);
		return mem[pos][target];
		
	}
	
	public static void main(String[] args){
		
		int n = 4;
		int x = 1;
		System.out.print(numberOfWays(n, x));
		
	}
	
}