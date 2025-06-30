import java.util.Queue;
import java.util.LinkedList;

class Longest{
	
	static int countSubSequence(String s, String next){
		int i = 0, j = 0;
		int size = next.length();
		int subSeqCount = 0;
		
		while(i < s.length()){
			if(s.charAt(i) == next.charAt(j)){
				j++;
				if(j == size){
					j = 0;
					subSeqCount++;
				}
			}
			i++;
		}
		
		return subSeqCount;
		
	}
	
	static String longestSubsequenceRepeatedK(String s, int k){
		int size = s.length();
		int[] freq = new int[26];
		for(int i = 0; i < size; i++){
			freq[s.charAt(i) - 'a']++;
		}
		
		String curr = "";
		Queue<String> queue = new LinkedList<>();
		queue.offer(curr);
		String res = "";
		
		while(!queue.isEmpty()){
			curr = queue.poll();
			
			for(char ch = 'a'; ch <= 'z'; ch++){
				if(freq[ch - 'a'] < k){
					continue;
				}
				String next = curr + ch;
				if(countSubSequence(s, next) >= k){
					res = next;
					queue.offer(next);
				}
			}
		}
		
		return res;
		
	}
	
	public static void main(String[] args){
		String s = "letsleetcode";
		int k = 2;
		System.out.println(longestSubsequenceRepeatedK(s, k));
	}
	
}