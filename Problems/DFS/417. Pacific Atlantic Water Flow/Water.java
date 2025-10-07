/*

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the 
island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents 
the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the 
neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into 
the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both 
the Pacific and Atlantic oceans.

Example 1:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

Example 2:
Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.
 

Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105

*/

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

class Water {

    static int[][] heights;
    static int m;
    static int n;

    static void iterateRow(int row, boolean[][] visited) {
        for (int col = 0; col < n; col++) {
            DFS(row, col, visited);
        }
    }

    static void iterateCol(int col, boolean[][] visited) {
        for (int row = 0; row < m; row++) {
            DFS(row, col, visited);
        }
    }

    static List<List<Integer>> pacificAtlantic(int[][] inputHeights) {
        heights = inputHeights;
        m = heights.length;
        n = heights[0].length;

        List<List<Integer>> res = new LinkedList<>();

        boolean[][] pacificTable = new boolean[m][n];
        iterateRow(0, pacificTable);
        iterateCol(0, pacificTable);

        boolean[][] atlanticTable = new boolean[m][n];
        iterateRow(m - 1, atlanticTable);
        iterateCol(n - 1, atlanticTable);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlanticTable[i][j] && pacificTable[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    static void DFS(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int curCellVal = heights[row][col];

        // Top
        if (row - 1 >= 0 && heights[row - 1][col] >= curCellVal && !visited[row - 1][col]) {
            DFS(row - 1, col, visited);
        }
        // Left
        if (col - 1 >= 0 && heights[row][col - 1] >= curCellVal && !visited[row][col - 1]) {
            DFS(row, col - 1, visited);
        }
        // Right
        if (col + 1 < n && heights[row][col + 1] >= curCellVal && !visited[row][col + 1]) {
            DFS(row, col + 1, visited);
        }
        // Down
        if (row + 1 < m && heights[row + 1][col] >= curCellVal && !visited[row + 1][col]) {
            DFS(row + 1, col, visited);
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        List<List<Integer>> res = pacificAtlantic(heights);

        for (List<Integer> arr : res) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
