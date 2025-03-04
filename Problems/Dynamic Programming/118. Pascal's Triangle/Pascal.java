/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers 
directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]
 
 */
import java.util.ArrayList;
import java.util.List;

class Pascal{
    static void findPascalTriangle(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(List.of(1));

        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < triangle.get(i-1).size()-1; j++){
                row.add(triangle.get(i-1).get(j) + triangle.get(i-1).get(j+1));
            }
            row.add(1);
            triangle.add(row);
        }

        for(List<Integer> arr : triangle){
            for(int num : arr){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int numRows = 5;
        findPascalTriangle(numRows);
    }
}