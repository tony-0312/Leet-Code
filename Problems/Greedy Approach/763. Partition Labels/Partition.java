/*
You are given a string s. We want to partition the string into as many parts as possible so 
that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into 
["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]
*/

import java.util.List;
import java.util.ArrayList;

class Partition{
	
	static List<Integer> findPartition(String s){
		int[] lastIndex = new int[26];
		int size = s.length();
		
		for(int i = 0; i < size; i++){
			lastIndex[s.charAt(i) - 'a'] = i;
		}
		
		List<Integer> ans = new ArrayList<>();
		
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < size; i++){
			end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
			
			if(end == i){
				ans.add(i - start + 1);
				start = i + 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args){
		String s = "ababcbacadefegdehijhklij";
		List<Integer> ans = findPartition(s);
		for(int num : ans){
			System.out.println(num + " ");
		}
	}
}