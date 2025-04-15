/*
You are given two positive integers low and high.

An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal 
to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

Return the number of symmetric integers in the range [low, high].

Example 1:
Input: low = 1, high = 100
Output: 9
Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.

Example 2:
Input: low = 1200, high = 1230
Output: 4
Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
*/

class Count{
	
	static int countSymmetricNumbers(int low, int high){
		int count = 0;
		
		for(int i = low; i <= high; i++){
			
			StringBuilder str = new StringBuilder();
			str.append(i);
			if(str.length() % 2 == 0){
				// String str1 = str.substring(0, str.length()/2);
				// String str2 = str.substring(str.length()/2, str.length());
				int half = str.length() / 2;
				int sum1 = 0, sum2 = 0;
				for(int j = 0; j < half; j++){
					sum1 += str.charAt(j);
					sum2 += str.charAt(j + half);
				}
				// for(int k = 0; k < str2.length(); k++){
					// sum2 += (int)str2.charAt(k);
				// }
				if((sum1 != 0 && sum2 != 0) && sum1 == sum2){
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		int low = 1200, high = 1230;
		System.out.println(countSymmetricNumbers(low, high));
	}
}