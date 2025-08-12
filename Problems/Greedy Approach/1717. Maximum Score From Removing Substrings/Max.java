/*

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.


Example 1:
Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

Example 2:
Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20

Constraints:
1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.

*/

class Max{
	
	static int maximumGain(String s, int x, int y){
		
		int res = 0;
		String top, bot;
		int top_score, bot_score;
		
		if(y > x){
			
			top = "ba";
			top_score = y;
			bot = "ab";
			bot_score = x;
			
		}else{
			
			top = "ab";
			top_score = x;
			bot = "ba";
			bot_score = y;
			
		}
		
		StringBuilder stack = new StringBuilder();
		for(char ch : s.toCharArray()){
			
			if(ch == top.charAt(1) && stack.length() > 0 && stack.charAt(stack.length() - 1) == top.charAt(0)){
				res += top_score;
				stack.setLength(stack.length() - 1);
			}else{
				stack.append(ch);
			}
			
		}
		
		StringBuilder newStack = new StringBuilder();
		for(char ch : stack.toString().toCharArray()){
			if(ch == bot.charAt(1) && newStack.length() > 0 && newStack.charAt(newStack.length() - 1) == bot.charAt(0)){
				res += bot_score;
				newStack.setLength(newStack.length() - 1);
			}else{
				newStack.append(ch);
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] args){
		
		String s = "cdbcbbaaabab";
		int x = 4;
		int y = 5;
		System.out.print(maximumGain(s, x, y));
		
	}
	
}