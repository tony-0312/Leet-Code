/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:
Input: n = 2
Output: [1,2]
 

Constraints:
1 <= n <= 5 * 104

*/

import java.util.List;
import java.util.ArrayList;

class Sort{

    static void dfs(int curr, int n, List<Integer> ans){
        if(curr > n) return;

        ans.add(curr);
        for(int i = 0; i <= 9; i++){
            dfs(curr * 10 + i, n, ans);
        }
    }

    static List<Integer> lexicalOrder(int n){
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <=9; i++){
            dfs(i, n, ans);
        }

        return ans;
    }

    public static void main(String[] args){
        int n = 13;
        List<Integer> ans = lexicalOrder(n);
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}
