/*
You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.

While there is a '*', do the following operation:

Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, 
you can delete any of them.
Return the lexicographically smallest resulting string after removing all '*' characters.

Example 1:
Input: s = "aaba*"

Output: "aab"

Explanation:
We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest.

Example 2:
Input: s = "abc"

Output: "abc"

Explanation:
There is no '*' in the string.


Constraints:
1 <= s.length <= 105
s consists only of lowercase English letters and '*'.
The input is generated such that it is possible to delete all '*' characters.

*/

import java.util.List;
import java.util.ArrayList;

class Min{
	
	static String clearStars(String s){
		List<List<Integer>> charPos = new ArrayList<>();
		
		for(int i = 0; i < 26; i++){
			charPos.add(new ArrayList<>());
		}
		
		char[] arr = s.toCharArray();
		
		for(int i = 0; i < s.length(); i++){
			if(arr[i] == '*'){
				for(int j = 0; j < 26; j++){
					if(!charPos.get(j).isEmpty()){
						int pos = charPos.get(j).remove(charPos.get(j).size() - 1);
						arr[pos] = '&';
						break;
					}
				}
			}
			else{
				charPos.get(arr[i] - 'a').add(i);
			}
		}
		
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != '*' && arr[i] != '&'){
				res.append(arr[i]);
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args){
		String s = "aaba*";
		System.out.println(clearStars(s));
	}
	
}