/*
You are given an integer num. You know that Bob will sneakily remap one of the 10 possible digits (0 to 9) to another digit.

Return the difference between the maximum and minimum values Bob can make by remapping exactly one digit in num.

Notes:

When Bob remaps a digit d1 to another digit d2, Bob replaces all occurrences of d1 in num with d2.
Bob can remap a digit to itself, in which case num does not change.
Bob can remap different digits for obtaining minimum and maximum values respectively.
The resulting number after remapping can contain leading zeroes.
 

Example 1:
Input: num = 11891
Output: 99009
Explanation: 
To achieve the maximum value, Bob can remap the digit 1 to the digit 9 to yield 99899.
To achieve the minimum value, Bob can remap the digit 1 to the digit 0, yielding 890.
The difference between these two numbers is 99009.

Example 2:
Input: num = 90
Output: 99
Explanation:
The maximum value that can be returned by the function is 99 (if 0 is replaced by 9) and the minimum value that can
 be returned by the function is 0 (if 9 is replaced by 0).
Thus, we return 99.

Constraints:
1 <= num <= 108
*/

class Max{
	
	static int minMaxDifference(int num){
		String s = Integer.toString(num);
		char[] maxArray = s.toCharArray();
		char[] minArray = s.toCharArray();
		
		char replaceMax = ' ';
		for(char ch : maxArray){
			if(ch != '9'){
				replaceMax = ch;
				break;
			}
		}
		
		for(int i = 0; i < maxArray.length; i++){
			if(maxArray[i] == replaceMax){
				maxArray[i] = '9';
			}
		}
		
		char replaceMin = minArray[0];
		
		for(int i = 0; i < minArray.length; i++){
			if(minArray[i] == replaceMin){
				minArray[i] = '0';
			}
		}
		
		int maxNum = Integer.parseInt(new String(maxArray));
		int minNum = Integer.parseInt(new String(minArray));
		
		return maxNum - minNum;
	}
	
	public static void main(String[] args){
		int num = 11891;
		System.out.println(minMaxDifference(num));
	}
}