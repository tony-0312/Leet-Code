/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */
class CommonPrefix{
    static String longestCommonPrefix(String[] strs) {
        int noOfStrings = strs.length;

        for(int i = 0; i < strs[0].length(); i++){
            for(int strInd = 1; strInd < noOfStrings; strInd++){
                if(strs[strInd].length() <= i || strs[0].charAt(i) != strs[strInd].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}