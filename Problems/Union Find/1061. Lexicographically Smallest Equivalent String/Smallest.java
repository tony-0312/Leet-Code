/*
You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings 
of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

Example 1:
Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".

Example 2:
Input: s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".

Example 3:
Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 

Constraints:
1 <= s1.length, s2.length, baseStr <= 1000
s1.length == s2.length
s1, s2, and baseStr consist of lowercase English letters.
*/

import java.util.Arrays;

class Smallest{
	
	static int find(int[] disjoint, int v){
		if(disjoint[v] == -1)
			return v;
		return disjoint[v] = find(disjoint, disjoint[v]);
	}
	
	static String smallestEquivalentString(String s1, String s2, String baseStr){
		int[] disjoint = new int[26];
		Arrays.fill(disjoint, -1);
		
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) == s2.charAt(i))
				continue;
			
			int pos1 = find(disjoint, s1.charAt(i) - 'a');
			int pos2 = find(disjoint, s2.charAt(i) - 'a');
			
			if(pos1 == pos2)
				continue;
			
			if(pos1 > pos2)
				disjoint[pos1] = pos2;
			else
				disjoint[pos2] = pos1;
		}
		
		StringBuilder res = new StringBuilder();
		
		for(int i = 0; i < baseStr.length(); i++){
			int parent = find(disjoint, baseStr.charAt(i) - 'a');
			res.append((char) (parent + 'a'));
		}
		
		return res.toString();
	}
	
	public static void main(String[] args){
		String s1 = "parker";
		String s2 = "morris";
		String baseStr = "parser";
		
		System.out.println(smallestEquivalentString(s1, s2, baseStr));
	}
}