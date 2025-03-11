/*
 * Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of 
all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters 
a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b 
and c are "aaacb", "aacb" and "acb". 

Example 3:
Input: s = "abc"
Output: 1
 */
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

class Substring{
    static int numberOfStrings(String s){
        int ans = 0;
        Dictionary<Character, Integer> lastSeen = new Hashtable<>(Map.of('a',-1,'b',-1,'c',-1));
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            lastSeen.put(ch, i);
            int min = Math.min(lastSeen.get('a'), Math.min(lastSeen.get('b'), lastSeen.get('c')));
            ans += min + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfStrings(s));
    }
}