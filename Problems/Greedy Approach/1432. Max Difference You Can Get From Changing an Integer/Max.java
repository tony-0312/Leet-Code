/*
You are given an integer num. You will apply the following steps to num two separate times:

Pick a digit x (0 <= x <= 9).
Pick another digit y (0 <= y <= 9). Note y can be equal to x.
Replace all the occurrences of x in the decimal representation of num by y.
Let a and b be the two results from applying the operation to num independently.

Return the max difference between a and b.

Note that neither a nor b may have any leading zeros, and must not be 0.

Example 1:
Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888

Example 2:
Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8
 
Constraints:
1 <= num <= 108
*/

class Max{
	
	static int maxDiff(int num){
		String s = Integer.toString(num);
		char[] maxChars = s.toCharArray();
		char[] minChars = s.toCharArray();
		
		int size = s.length();
		
		for(int i = 0; i < size; i++){
			if(maxChars[i] != '9'){
				char ch = maxChars[i];
				System.out.println(ch);
				for(int j = 0; j < size; j++){
					if(maxChars[j] == ch){
						maxChars[j] = '9';
					}
				}
				break;
			}
		}
		int maxNum = Integer.parseInt(new String(maxChars));
		System.out.println(maxNum);
		if(minChars[0] > '1'){
			char ch = minChars[0];
			
			for(int i = 0; i < size; i++){
				if(minChars[i] == ch){
					minChars[i] = '1';
				}
			}
		}else{
			for(int i = 1; i < size; i++){
				if(minChars[i] > '1'){
					char ch = minChars[i];
					for(int j = i; j < size; j++){
						if(minChars[j] == ch){
							minChars[j] = '0';
						}
					}
					break;
				}
				
			}
		}
		
		maxNum = Integer.parseInt(new String(maxChars));
		int minNum = Integer.parseInt(new String(minChars));
		
		return maxNum - minNum;
	}
	
	public static void main(String[] args){
		int num = 9288;
		System.out.println(maxDiff(num));
	}
	
}