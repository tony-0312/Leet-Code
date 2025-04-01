import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class MinIndex{
	
	static int findMinIndex(List<Integer> nums){
		int mostFreq = 0;
		int maxFreq = 0;
		Map<Integer, Integer> freqMap = new HashMap<>();		
		
		for(int num : nums){
			int currFreq = freqMap.merge(num, 1, Integer::sum);
			if(maxFreq < currFreq){
				maxFreq = currFreq;
				mostFreq = num;
			}
		}
		
		int currFreqCount = 0;
		for(int i = 1; i <= nums.size(); i++){
			if(nums.get(i-1).equals(mostFreq)){
				currFreqCount++;
				if(currFreqCount * 2 > i && (maxFreq - currFreqCount) *2 > nums.size()-i){
					return i - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		List<Integer> nums = new ArrayList<>(List.of(1,2,2,2));
		
		System.out.println(findMinIndex(nums));
		
	}
}