/*

Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. 
The value of the revision is its integer conversion ignoring leading zeros.

To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, 
treat the missing revision values as 0.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.

Example 1:
Input: version1 = "1.2", version2 = "1.10"

Output: -1

Explanation:
version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.

Example 2:
Input: version1 = "1.01", version2 = "1.001"

Output: 0

Explanation:
Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Example 3:
Input: version1 = "1.0", version2 = "1.0.0.0"

Output: 0

Explanation:
version1 has less revisions, which means every missing revision are treated as "0".

Constraints:
1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.

*/

class Compare{
	
	static int compareVersion(String version1, String version2){
		
		String[] levels1 = version1.split("\\.");
		String[] levels2 = version2.split("\\.");
		
		int length = Math.max(levels1.length, levels2.length);
		
		for(int i = 0; i < length; i++){
			
			Integer v1 = 1 < levels1.length ? Integer.parseInt(levels1[i]) : 0;
			Integer v2 = 1 < levels2.length ? Integer.parseInt(levels2[i]) : 0;
			int compare = v1.compareTo(v2);
			
			if(compare != 0)
				return compare;
			
		}
		
		return 0;
		
	}
	
	public static void main(String[] args){
		
		String version1 = "1.2";
		String version2 = "1.10";
		System.out.print(compareVersion(version1, version2));
		
	}
	
}