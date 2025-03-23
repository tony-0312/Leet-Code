import java.util.Arrays;
class UnionFind{
	private int[] parent;
	private int[] rank;
	public UnionFind(int n){
		parent = new int[n];
		rank = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = i;
		}
	}
	
	public int find(int i){
		int root = parent[i];
		if(parent[root] != root){
			return parent[i] = find(root);
		}
		return root;
	}
	
	public void union(int i, int j){
		int iroot = find(i);
		int jroot = find(j);
		
		if(iroot == jroot) return;
		
		if(rank[iroot] < rank[jroot]){
			parent[iroot] = jroot;
		}else if(rank[iroot] > rank[jroot]){
			parent[jroot] = iroot;
		}else{
			parent[jroot] = iroot;
			rank[iroot] = rank[iroot] + 1;
		}
	}
	
}
class MinCost{
	private static UnionFind uf;
	private static int[] g;
	
	static int[] minimumCost(int n, int[][] edges, int[][] query){
		uf = new UnionFind(n);
		int[] ans = new int[query.length];
		
		for(int[] e : edges){
			uf.union(e[0], e[1]);
		}
		
		g = new int[n];
		Arrays.fill(g, -1);
		
		for(int[] e : edges){
			int root = uf.find(e[0]);
			g[root] &= e[2];
		}
		
		for(int i = 0; i < query.length; i++){
			int start = query[i][0];
			int end = query[i][1];
			ans[i] = f(start, end);
		}
		return ans;
	}
	
	static int f(int s, int e){
		if(s == e) return 0;
		int a = uf.find(s);
		int b = uf.find(e);
		return a == b ? g[a] : -1;
	}
	
	public static void main(String[] args){
		int n = 5;
		int edges[][] = {{0,1,7},{1,3,7},{1,2,1}};
		int query[][] = {{0,3},{3,4}};
		
		int[] ans = minimumCost(n, edges, query);
		for(int num : ans){
			System.out.print(num + " ");
		}
	}
}