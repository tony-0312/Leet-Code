/*
You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:

	status[i] is 1 if the ith box is open and 0 if the ith box is closed,
	candies[i] is the number of candies in the ith box,
	keys[i] is a list of the labels of the boxes you can open after opening the ith box.
	containedBoxes[i] is a list of the boxes you found inside the ith box.

You are given an integer array initialBoxes that contains the labels of the boxes you initially have. You can take all the candies 
in any open box and you can use the keys in it to open new boxes and you also can use the boxes you find in it.

Return the maximum number of candies you can get following the rules above.

Example 1:
Input: status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
Output: 16
Explanation: You will be initially given box 0. You will find 7 candies in it and boxes 1 and 2.
Box 1 is closed and you do not have a key for it so you will open box 2. You will find 4 candies and a key to box 1 in box 2.
In box 1, you will find 5 candies and box 3 but you will not find a key to box 3 so box 3 will remain closed.
Total number of candies collected = 7 + 4 + 5 = 16 candy.

Example 2:
Input: status = [1,0,0,0,0,0], candies = [1,1,1,1,1,1], keys = [[1,2,3,4,5],[],[],[],[],[]], containedBoxes = [[1,2,3,4,5],[],[],[],[],[]], 
initialBoxes = [0]
Output: 6
Explanation: You have initially box 0. Opening it you can find boxes 1,2,3,4 and 5 and their keys.
The total number of candies will be 6.
*/

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Max{
    
    static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes){
        int n = candies.length;
        Queue<Integer> q = new LinkedList<>();
        for(int node : initialBoxes){
            q.offer(node);
        }
        Set<Integer> closed = new HashSet<>();
        int total = 0;
        while(!q.isEmpty()){
            int curr = q.poll();

            if(status[curr] == 0){
                closed.add(curr);
                continue;
            }

            for(int open : keys[curr]){
                status[open] = 1;
                if(closed.contains(open)){
                    q.offer(open);
                    closed.remove(open);
                }
            }

            total += candies[curr];
            
            for(int neighbour : containedBoxes[curr]){
                q.offer(neighbour);
            }
        }

        return total;

    }

    public static void main(String[] args){
        int[] status = {1,0,1,0};
        int[] candies = {7,5,4,100};
        int[][] keys = {{},{},{1},{}};
        int[][] containedBoxes = {{1,2},{3},{},{}};
        int[] initialBoxes = {0};
        System.out.println(maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}
