/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 
8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
Return the quotient after dividing dividend by divisor.
Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
*/
class Divide{

	static int divide(int dividend, int divisor){
		boolean sign = true;
        if((dividend < 0) != (divisor < 0)){
                sign = false;
        }
		long longDividend = Math.abs((long) dividend);
		long longDivisor = Math.abs((long) divisor);
		long total = 0;
		
		while(longDividend >= longDivisor){
			int count = 0;

			while(longDividend >= (longDivisor << (count + 1))){
				count++;
			}
			total += 1L << count;
			longDividend -= longDivisor << count;
		}
		long result;
        if(!sign){
            result = ~total + 1;
        }else{
            result = total;
        }

		if(result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE){
			return (int) result;
		}

		return Integer.MAX_VALUE;
	}

	public static void main(String[] args){
		int dividend = 10;
		int divisor = 3;
		System.out.println(divide(dividend, divisor));
	}
}
