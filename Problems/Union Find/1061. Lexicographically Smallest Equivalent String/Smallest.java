import java.util.Arrays;

class Smallest{
	
	static int find(int[] disjoint, int v){
		if(disjoint[v] == -1)
			return v;
		return disjoint[v] = find(disjoint, disjoint[v]);
	}
	
	static String smallestEquivalentString(String s1, String s2, String baseStr){
		int[] disjoint = new int[26];
		Arrays.fill(disjoint, -1);
		
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) == s2.charAt(i))
				continue;
			
			int pos1 = find(disjoint, s1.charAt(i) - 'a');
			int pos2 = find(disjoint, s2.charAt(i) - 'a');
			
			if(pos1 == pos2)
				continue;
			
			if(pos1 > pos2)
				disjoint[pos1] = pos2;
			else
				disjoint[pos2] = pos1;
		}
		
		StringBuilder res = new StringBuilder();
		
		for(int i = 0; i < baseStr.length(); i++){
			int parent = find(disjoint, baseStr.charAt(i) - 'a');
			res.append((char) (parent + 'a'));
		}
		
		return res.toString();
	}
	
	public static void main(String[] args){
		String s1 = "parker";
		String s2 = "morris";
		String baseStr = "parser";
		
		System.out.println(smallestEquivalentString(s1, s2, baseStr));
	}
}