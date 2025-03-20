class UnionFind{
	private int[] parent;
	
	public UnionFind(int size){
		parent = new int[size];
		
		for(int i = 0; i < size; i++){
			parent[i] = i;
		}
	}
	
	public int find(int i){
		
		if(parent[i] == i){
			return i;
		}
		
		return find(parent[i]);
	}
	
	public void union(int i, int j){
		
		int irep = find(i);
		int jrep = find(j);
		
		parent[irep] = jrep;
	}
}

class Runner{
	public static void main(String[] args){
		int size = 5;
		UnionFind uf = new UnionFind(size);
		uf.union(0,1);
		uf.union(1,2);
		uf.union(2,3);
		System.out.println(uf.find(1));
		System.out.println(uf.find(0));
	}
}