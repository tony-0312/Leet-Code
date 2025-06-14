/*
You are given a string s consisting of lowercase English letters.

Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 
in the string such that:

a1 has an odd frequency in the string.
a2 has an even frequency in the string.
Return this maximum difference.

Example 1:
Input: s = "aaaaabbc"

Output: 3

Explanation:

The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3.

Example 2:
Input: s = "abcabcab"

Output: 1

Explanation:

The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
The maximum difference is 3 - 2 = 1.
 

Constraints:
3 <= s.length <= 100
s consists only of lowercase English letters.
s contains at least one character with an odd frequency and one with an even frequency.
*/

class Diff{
	
	static int maxDifference(String s){
		int[] map = new int[26];
		
		for(char ch : s.toCharArray()){
			map[ch - 'a']++;
		}
		
		int oddMax = 0;
		int evenMin = s.length();
		
		for(int i = 0; i < 26; i++){
			if(map[i] %2 != 0){
				oddMax = Math.max(oddMax, map[i]);
			}
			if(map[i] %2 == 0 && map[i] > 0){
				evenMin = Math.min(evenMin, map[i]);
			}
		}
		return oddMax - evenMin;
	}
	
	public static void main(String[] args){
		String s = "aaaaabbc";
		System.out.println(maxDifference(s));
	}
}