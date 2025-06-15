import java.util.Arrays;

class MaxDiff{
	
	static void precomputePrefixSum(int[] prefixSumA, int[] prefixSumB, String s, int size, int a, int b){
		
		prefixSumA[0] = prefixSumB[0] = 0;
		
		for(int i = 0; i < size; i++){
			if(s.charAt(i) - '0' == a)
				prefixSumA[i+1] = 1 + prefixSumA[i];
			else
				prefixSumA[i+1] = prefixSumA[i];
			
			if(s.charAt(i) - '0' == b)
				prefixSumB[i+1] = 1 + prefixSumB[i];
			else
				prefixSumB[i+1] = prefixSumB[i];
			
		}
		
	}
	
	static int calculateDifference(String s, int k, int a, int b){
		
		int size = s.length();
		int[] prefixSumA = new int[size + 1];
		int[] prefixSumB = new int[size + 1];
		precomputePrefixSum(prefixSumA, prefixSumB, s, size, a, b);
		
		int[] minVal = new int[4];
		int[] minIdx = new int[4];
		
		Arrays.fill(minVal, Integer.MAX_VALUE);
		Arrays.fill(minIdx, -1);
		
		minVal[0] = minIdx[0] = 0;
		int maxDiff = Integer.MIN_VALUE;
		
		for(int end = k; end <= size; end++){
			int parityA = prefixSumA[end] & 1;
			int parityB = prefixSumB[end] & 1;
			int parity = ((parityA ^ 1) << 1) + parityB;
			
			if(minVal[parity] != Integer.MAX_VALUE){
				if(prefixSumB[minIdx[parity]] != prefixSumB[end]){
					maxDiff = Math.max(maxDiff, (prefixSumA[end] - prefixSumB[end]) - minVal[parity]);
				}
			}
			
			int start = end - k + 1;
			parityA = prefixSumA[start] & 1;
			parityB = prefixSumB[start] & 1;
			parity = (parityA << 1) + parityB;
			int startDiff = prefixSumA[start] - prefixSumB[start];
			
			if(startDiff < minVal[parity]){
				minVal[parity] = startDiff;
				minIdx[parity] = start;
			}
			
		}

		return maxDiff;
		
	}
	
	static int maxDifference(String s, int k){
		int maxDiff = Integer.MIN_VALUE;
		
		for(int a = 0; a <= 4; a++){
			for(int b = 0; b <= 4; b++){
				if(a == b)
					continue;
				int diff = calculateDifference(s, k, a, b);
				maxDiff = Math.max(diff, maxDiff);
			}
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args){
		String s = "1122211";
		int k = 3;
		System.out.println(maxDifference(s, k));
	}
	
}