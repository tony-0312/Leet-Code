/*

A magician has various spells.

You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.

It is a known fact that if a magician decides to cast a spell with a damage of power[i], they cannot cast any spell with a damage 
of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.

Each spell can be cast only once.

Return the maximum possible total damage that a magician can cast.

Example 1:
Input: power = [1,1,3,4]

Output: 6

Explanation:
The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.

Example 2:
Input: power = [7,1,6,6]

Output: 13

Explanation:
The maximum possible damage of 13 is produced by casting spells 1, 2, 3 with damage 1, 6, 6.

Constraints:
1 <= power.length <= 105
1 <= power[i] <= 109

*/

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Max{
	
	
	static long maximumTotalDamage(int[] power){
		
		Map<Integer, Long> damageFreq = new HashMap<>();
		for(int damage : power){
			
			damageFreq.put(damage, damageFreq.getOrDefault(damage, 0L) + 1);
			
		}
		
		List<Integer> uniqueDamages = new ArrayList<>(damageFreq.keySet());
		Collections.sort(uniqueDamages);
		
		int totalUniqueDamages = uniqueDamages.size();
		long[] maxDamageDP = new long[totalUniqueDamages];
		
		maxDamageDP[0] = uniqueDamages.get(0) * damageFreq.get(uniqueDamages.get(0));
		
		for(int i = 1; i < totalUniqueDamages; i++){
			
			int currentDamageValue = uniqueDamages.get(i);
			long currentDamageTotal = currentDamageValue * damageFreq.get(currentDamageValue);
			
			maxDamageDP[i] = maxDamageDP[i - 1];
			
			int prevIndex = i - 1;
			while(prevIndex >= 0 &&
					(uniqueDamages.get(prevIndex) == currentDamageValue - 1 ||
					 uniqueDamages.get(prevIndex) == currentDamageValue - 2 ||
					 uniqueDamages.get(prevIndex) == currentDamageValue + 1 ||
					 uniqueDamages.get(prevIndex) == currentDamageValue + 2)){
					
					prevIndex--;
					
			}
			
			if(prevIndex >= 0){
				maxDamageDP[i] = Math.max(maxDamageDP[i], maxDamageDP[prevIndex] + currentDamageTotal);
			}else{
				maxDamageDP[i] = Math.max(maxDamageDP[i], currentDamageTotal);
			}
			
		}
		
		return maxDamageDP[totalUniqueDamages - 1];
		
	}
	
	public static void main(String[] args){
		
		int[] power = {1,1,3,4};
		System.out.print(maximumTotalDamage(power));
		
	}
	
}