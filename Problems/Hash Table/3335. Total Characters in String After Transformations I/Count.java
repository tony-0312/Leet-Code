/*
You are given a string s and an integer t, representing the number of transformations to perform. 
In one transformation, every character in s is replaced according to the following rules:

If the character is 'z', replace it with the string "ab".
Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 
'b' is replaced with 'c', and so on.
Return the length of the resulting string after exactly t transformations.

Since the answer may be very large, return it modulo 109 + 7.

Example 1:
Input: s = "abcyy", t = 2

Output: 7

Explanation:

First Transformation (t = 1):
'a' becomes 'b'
'b' becomes 'c'
'c' becomes 'd'
'y' becomes 'z'
'y' becomes 'z'
String after the first transformation: "bcdzz"
Second Transformation (t = 2):
'b' becomes 'c'
'c' becomes 'd'
'd' becomes 'e'
'z' becomes "ab"
'z' becomes "ab"
String after the second transformation: "cdeabab"
Final Length of the string: The string is "cdeabab", which has 7 characters.

Example 2:
Input: s = "azbk", t = 1

Output: 5

Explanation:

First Transformation (t = 1):
'a' becomes 'b'
'z' becomes "ab"
'b' becomes 'c'
'k' becomes 'l'
String after the first transformation: "babcl"
Final Length of the string: The string is "babcl", which has 5 characters.
*/

class Count{
	private static final int MOD = 1_000_000_007;
	
	static int addMod(int a, int b){
		a += b;
		if(a >= MOD) a -= MOD;
		return a;
	}
	
	static int findLength(String s, int t){
		int[] currFreq = new int[26];
		int ans = 0;
		for(char c : s.toCharArray()){
			currFreq[c - 'a']++;
		}
		
		while(t-- > 0){
			int[] nextFreq = new int[26];
			for(int i = 0; i < 26; i++){
				if(i < 25){
					nextFreq[i+1] = currFreq[i];
				}else{
					nextFreq[0] = currFreq[25];
					nextFreq[1] = addMod(nextFreq[1], currFreq[25]);
				}
			}
			currFreq = nextFreq;
		}
		for(int num : currFreq){
			ans = addMod(ans, num);
		}
		return ans;
	}
	
	public static void main(String[] args){
		String s = "abcyy";
		int t = 2;
		System.out.print(findLength(s, t));
	}
	
}