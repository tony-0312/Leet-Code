class UnionFind{
	int size;
	int[] rank, parent;
	
	public UnionFind(int size){
		rank = new int[size];
		parent = new int[size];
		this.size = size;
		
		for(int i = 0; i < size; i++){
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

class Runner{
	public static void main(String[] args){
		int size = 6;
		UnionFind uf = new UnionFind(size);
		uf.union(0,1);
		uf.union(1,3);
		uf.union(0,4);
		uf.union(2,5);
		System.out.println(uf.find(4) == uf.find(5));
	}
}