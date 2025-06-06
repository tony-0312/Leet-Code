

class Smallest{
	
	static char smallest(int[] freq){
		for(int i = 0; i < 26; i++){
			if(freq[i] > 0){
				return (char) ('a' + i);
			}
		}
		return 'z';
	}
	
	static String robotWithString(String s){
		int size = s.length();
		int[] freq = new int[26];
		
		for(int i = 0; i < size; i++){
			freq[s.charAt(i) - 'a']++;
		}
		
		StringBuilder t = new StringBuilder();
		StringBuilder res = new StringBuilder();
		int pos = 0;
		
		while(pos < size){
			t.append(s.charAt(pos));
			freq[s.charAt(pos) - 'a']--;
			
			while(t.length() > 0 && t.charAt(t.length() - 1) <= smallest(freq)){
				res.append(t.charAt(t.length() - 1));
				t.deleteCharAt(t.length() - 1);
			}
			pos++;
		}
		return res.toString();
	}
	
	public static void main(String[] args){
		String s = "zza";
		System.out.println(robotWithString(s));
	}
}