/*
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. 
Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

Example 1:
Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.

Example 2:
Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.

Example 3:
Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
*/

import java.util.HashMap;
import java.util.Map;

class Longest{
	
	static int longestPalindrome(String[] words){
		int[][] mpp = new int[26][26];
		int count = 0;
		int middle = 0;
		for(String word : words){
			int x = word.charAt(0) - 'a';
			int y = word.charAt(1) - 'a';
			if(mpp[y][x] > 0){
				mpp[y][x]--;
				count += 4;
				if(x==y) middle--;
			}else{
				mpp[x][y]++;
				if(x==y) middle++;
			}
		}
		if(middle > 0) count+=2;
		return count;
	}
	
	public static void main(String[] args){
		String[] words = {"ab","ty","yt","lc","cl","ab"};
		System.out.println(longestPalindrome(words));
	}
	
}