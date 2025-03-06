/*
 * You are given a 0-indexed 2D integer matrix grid of size n * n 
 * with values in the range [1, n2]. Each integer appears exactly once except a which appears 
 * twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

Example 1:
Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].

Example 2:
Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
 */
import java.util.HashMap;
import java.util.Map;

class MissRepeated{
    public static void main(String[] args) {
        int[][] grid = {{1, 3}, {2, 2}};
        Map<Integer, Integer> hmap = new HashMap<>();
        int size = grid.length;
        int[] ans = new int[2];
        int sum = 0;
        for(int i = 0; i < size * size; i++){
            int row = i / size;
            int col = i % size;
            if(!hmap.containsKey(grid[row][col])) sum+=grid[row][col];
            hmap.put(grid[row][col], hmap.getOrDefault(grid[row][col], 0)+1);
            
        }
        int n = size * size;
        int series = (n*(n + 1))/2;
        for(Map.Entry entrySet : hmap.entrySet()){
            if((int)entrySet.getValue() > 1){
                ans[0] = (int)entrySet.getKey();
            }
        }
        ans[1] = series - sum;
        System.out.println("Repeated Number: "+ ans[0]);
        System.out.println("Missing Number: "+ ans[1]);
    }
}