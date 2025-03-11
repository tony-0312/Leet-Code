/*
 * You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel 
('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

Example 1:
Input: word = "aeioqq", k = 1

Output: 0

Explanation:

There is no substring with every vowel.

Example 2:
Input: word = "aeiou", k = 0

Output: 1

Explanation:

The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:
Input: word = "ieaouqqieaouqq", k = 1

Output: 3

Explanation:

The substrings with every vowel and one consonant are:

word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".
 */
import java.util.HashMap;
import java.util.Map;

class CountSubstring{
    static long countOfSubstrings(String word, int k){
        return find(word, k) - find(word, k + 1);
    }

    static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

    static long find(String word, int k){
        long ans = 0;
        int l = 0;
        int nonVowel = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        for(char c : word.toCharArray()){
            if(isVowel(c)){
                cnt.merge(c, 1, Integer::sum);
            }else{
                nonVowel++;
            }
            while(nonVowel >= k && cnt.size() == 5){
                char charAtLeft = word.charAt(l++);
                if(isVowel(charAtLeft)){
                    if(cnt.merge(charAtLeft, -1, Integer::sum) == 0){
                        cnt.remove(charAtLeft);
                    }
                }else{
                    nonVowel--;
                }
                
            }
            ans += l;
        }
        return ans;
    }
    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k = 1;
        System.out.println(countOfSubstrings(word, k));
    }
}