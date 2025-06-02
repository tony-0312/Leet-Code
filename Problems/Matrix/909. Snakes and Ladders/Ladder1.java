import java.util.Queue;
import java.util.LinkedList;

class Ladder1{

    static int snakesAndLadder(int[][] board){
        int n = board.length;
        int MAX = n * n;
        boolean[] visited = new boolean[MAX + 1];
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();

                if(curr == MAX) return level;

                for(int next = curr + 1; next <= Math.min(curr + 6, MAX); next++){
                    int dest = next;
                    int row = (next - 1) / n;
                    int col = (next - 1) % n;
                    if(row % 2 == 1){
                           col = n - 1 - col;
                    }
                    row = n - 1 - row;
                    if(board[row][col] != -1){
                        dest = board[row][col];
                    }
                    if(!visited[dest]){
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,35,-1,-1,13,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadder(board));
    }
}
