/*

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 4, denominator = 333
Output: "0.(012)"

Constraints:
-231 <= numerator, denominator <= 231 - 1
denominator != 0

*/

import java.util.Map;
import java.util.HashMap;

class Fraction{
	
	static String fractionToDecimal(int numerator, int denominator){
		
		if(numerator == 0)
			return "0";
		
		StringBuilder fraction = new StringBuilder();
		
		if(numerator < 0 ^ denominator < 0)
			fraction.append("-");
		
		long dividend = Math.abs(Long.valueOf(numerator));
		long divisor = Math.abs(Long.valueOf(denominator));
		
		fraction.append(dividend / divisor);
		
		long remainder = dividend % divisor;
		
		if(remainder == 0)
			return fraction.toString();
		
		fraction.append(".");
		Map<Long, Integer> mpp = new HashMap<>();
		
		while(remainder != 0){
			
			if(mpp.containsKey(remainder)){
				
				fraction.insert(mpp.get(remainder), "(");
				fraction.append(")");
				break;
				
			}
			
			mpp.put(remainder, fraction.length());
			remainder *= 10;
			fraction.append(remainder / divisor);
			remainder %= divisor;
			
		}
		
		return fraction.toString();
		
	}
	
	public static void main(String[] args){
		
		int numerator = 4;
		int denominator = 333;
		System.out.print(fractionToDecimal(numerator, denominator));
		
	}
	
}