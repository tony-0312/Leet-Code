import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Maximize{
	
	static class Pair{
		
		int first, second;
		Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
		
	}
	
	public static int BFS(int start, List<List<Integer>> adj, int k){
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(start, -1));
		int count = 0;
		
		while(!q.isEmpty() && k >= 0){
			int size = q.size();
			count += size;
			for(int i = 0; i < size; i++){
				Pair curr = q.poll();
				int u = curr.first;
				int parent = curr.second;
				for(int v : adj.get(u)){
					if(v != parent){
						q.add(new Pair(v, u));
					}
				}
			}
			k--;
		}
		return count;
		
	}
	
	static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k){
		
		int m = edges1.length + 1; // Number of nodes in 1st tree
		int n = edges2.length + 1; // Number of nodes in 2nd tree
		
		// Create adjacency list for tree 1
		List<List<Integer>> adj1 = new ArrayList<>();
		for(int i = 0; i < m; i++){
			adj1.add(new ArrayList<>());
		}
		
		for(int[] edge : edges1){
			adj1.get(edge[0]).add(edge[1]);
			adj1.get(edge[1]).add(edge[0]);
		}
		
		// Create adjacency list for tree 2
		List<List<Integer>> adj2 = new ArrayList<>();
		for(int i = 0; i < n; i++){
			adj2.add(new ArrayList<>());
		}
		for(int[] edge : edges2){
			adj2.get(edge[0]).add(edge[1]);
			adj2.get(edge[1]).add(edge[0]);
		}
		
		int[] ans = new int[m];
		int best = 0;
		
		for(int i = 0; i < n; i++){
			int connections = BFS(i, adj2, k - 1);
			best = Math.max(connections, best);
		}
		
		for(int i = 0; i < m; i++){
			int connections = BFS(i, adj1, k);
			ans[i] = connections + best;
		}
		
		return ans;
		
	}
	
	public static void main(String[] args){
		
		int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
		int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
		int k = 2;
		int[] ans = maxTargetNodes(edges1, edges2, k);
		for(int num : ans){
			System.out.print(num + " ");
		}
	}
	
}