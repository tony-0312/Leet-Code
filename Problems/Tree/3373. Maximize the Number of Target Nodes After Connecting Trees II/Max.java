/*
There exist two undirected trees with n and m nodes, labeled from [0, n - 1] and [0, m - 1], respectively.

You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] 
indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

Node u is target to node v if the number of edges on the path from u to v is even. Note that a node is always target to itself.

Return an array of n integers answer, where answer[i] is the maximum possible number of nodes that are target to node i of the 
first tree if you had to connect one node from the first tree to another node in the second tree.

Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding 
to the next query.

Example 1:
Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]

Output: [8,7,7,8,8]

Explanation:

For i = 0, connect node 0 from the first tree to node 0 from the second tree.
For i = 1, connect node 1 from the first tree to node 4 from the second tree.
For i = 2, connect node 2 from the first tree to node 7 from the second tree.
For i = 3, connect node 3 from the first tree to node 0 from the second tree.
For i = 4, connect node 4 from the first tree to node 4 from the second tree.

Example 2:
Input: edges1 = [[0,1],[0,2],[0,3],[0,4]], edges2 = [[0,1],[1,2],[2,3]]

Output: [3,6,6,6,6]

Explanation:

For every i, connect node i of the first tree with any node of the second tree.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Max{


	static class Pair{
		int first, second;
		Pair (int first, int second){
			this.first = first;
			this.second = second;
		}
	}

	static int BFS(int start, List<List<Integer>> adj, boolean[] included){
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(start, -1));
		int count = 0, level = 0;

		while(!q.isEmpty()){
			int size = q.size();
			if(level % 2 == 0){
				count += size;
			}
			while(size-- > 0){
				Pair currPair = q.poll();
				int curr = currPair.first;
				int parent = currPair.second;
				if(included != null && level %2 == 0){
					included[curr] = true;
				}
				for(int v : adj.get(curr)){
					if(v == parent) continue;
					q.add(new Pair(v, curr));
				}
			}
			++level;
		}
		return count;
	}

	static int[] maxTargetNodes(int[][] edges1, int[][] edges2){
		int m = edges1.length + 1; // No. of nodes in tree1
		int n = edges2.length + 1; // No. of nodes in tree2
		List<List<Integer>> adj1 = new ArrayList<>();
		List<List<Integer>> adj2 = new ArrayList<>();
		for(int i = 0; i < m; i++){
			adj1.add(new ArrayList<>());
		}
		for(int i = 0; i < n; i++){
			adj2.add(new ArrayList<>());
		}
		for(int[] edge : edges1){
			adj1.get(edge[0]).add(edge[1]);
			adj1.get(edge[1]).add(edge[0]);
		}
		for(int[] edge : edges2){
			adj2.get(edge[0]).add(edge[1]);
			adj2.get(edge[1]).add(edge[0]);
		}
		int even_count2 = BFS(0, adj2, null);
		int odd_count2 = n - even_count2;
		int best2 = Math.max(even_count2, odd_count2);

		boolean[] included = new boolean[m];
		int even_count1 = BFS(0, adj1, included);
		int[] ans = new int[m];
		for(int i = 0; i < m; i++){
			if(included[i]){
				ans[i] = even_count1 + best2;
			}else{
				ans[i] = (m - even_count1) + best2;
			}
		}
		return ans;
	}

	public static void main(String[] args){
		int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
		int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
		int[] ans = maxTargetNodes(edges1, edges2);
		for(int num : ans){
			System.out.print(num + " ");
		}
	}
}
