/*

You are given two integers, m and k, and an integer array nums.

A sequence of integers seq is called magical if:
seq has a size of m.
0 <= seq[i] < nums.length
The binary representation of 2seq[0] + 2seq[1] + ... + 2seq[m - 1] has k set bits.
The array product of this sequence is defined as prod(seq) = (nums[seq[0]] * nums[seq[1]] * ... * nums[seq[m - 1]]).

Return the sum of the array products for all valid magical sequences.

Since the answer may be large, return it modulo 109 + 7.

A set bit refers to a bit in the binary representation of a number that has a value of 1.

Example 1:
Input: m = 5, k = 5, nums = [1,10,100,10000,1000000]

Output: 991600007

Explanation:
All permutations of [0, 1, 2, 3, 4] are magical sequences, each with an array product of 1013.

Example 2:
Input: m = 2, k = 2, nums = [5,4,3,2,1]

Output: 170

Explanation:
The magical sequences are [0, 1], [0, 2], [0, 3], [0, 4], [1, 0], [1, 2], [1, 3], [1, 4], [2, 0], [2, 1], [2, 3], [2, 4], 
[3, 0], [3, 1], [3, 2], [3, 4], [4, 0], [4, 1], [4, 2], and [4, 3].

Example 3:
Input: m = 1, k = 1, nums = [28]

Output: 28

Explanation:
The only magical sequence is [0].

Constraints:
1 <= k <= m <= 30
1 <= nums.length <= 50
1 <= nums[i] <= 108

*/

import java.util.Map;
import java.util.HashMap;

class Sum{
	
	private static final int MOD = 1_000_000_007;
	private int M, K, N;
	private int[] nums;
	private long[][] comb;
	private Map<State, Integer> memo;
	
	public int magicalSum(int m, int k, int[] nums){
		
		this.M = m;
		this.K = k;
		this.nums = nums;
		this.N = nums.length;
		
		comb = new long[+1][M+1];
		for(int n = 0; n <=M; n++){
			comb[n][0] = comb[n][n] = 1;
			for(int r = 1; r < n; r++){
				comb[n][r] = (comb[n-1][r-1] + comb[n-1][r]) % MOD;
			}
		}
		
		memo = new HashMap<>();
		
		return dp(M, K, 0, 0);
		
	}
	
	private int dp(int m, int k, int i, int flag){
		
		if(m < 0 || k < 0 || m + Integer.bitCount(flag) < k){
			return 0;
		}
		if(m == 0){
			return(k == Integer.bitCount(flag)) ? 1 : 0;
		}
		if(i >= N)
			return 0;
		State st = new State(m, k, i, flag);
		
		if(memo.containsKey(st))
			return memo.get(st);
		
		long res = 0;
		for(int c = 0; c <= m; c++){
			
			long mul = (comb[m][c] * modPow(nums[i], c)) % MOD;
			int newFlag = flag + c;
			int nextFlag = newFlag >> 1;
			int bitContribution = newFlag & 1;
			
			res = (res + mul * dp(m - c, k - bitContribution, i + 1, nextFlag)) % MOD;
			
		}
		
		int ans = (int)res;
		memo.put(st, ans);
		return ans;
		
	}
	
	private long modPow(long base, int exp){
		
		long result = 1;
		base %= MOD;
		while(exp > 0){
			
			if((exp & 1) == 1){
				result = (result * base) % MOD;
			}
			base = (base * base) % MOD;
			exp >>= 1;
			
		}
		
		return result;
		
	}
	
	private static class State{
		
		final int m, k, i, flag;
		State(int m, int k, int i, int flag){
			
			this.m = m;
			this.k = k;
			this.i = i;
			this.flag = flag;
			
		}
		@Override
		public boolean equals(Object o){
			
			if(!(o instanceof State))
				return false;
			State s = (State) o;
			return m == s.m && k == s.k && i == s.i && flag == s.flag;
			
		}
	
		@Override
		public int hashCode(){
			
			int h = m;
			h = h * 31 + k;
			h = h * 31 + i;
			h = h * 31 + flag;
			return h;
			
		}
		
	}
	
	public static void main(String[] args){
		
		Sum obj = new Sum();
		int m = 5;
		int k = 5;
		int[] nums = {1,10,100,10000,1000000};
		System.out.print(obj.magicalSum(m, k, nums));
		
	}
	
}