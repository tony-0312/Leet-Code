/*
 * Given two positive integers left and right, find the two integers num1 and num2 such that:

left <= num1 < num2 <= right .
Both num1 and num2 are prime numbers.
num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
Return the positive integer array ans = [num1, num2]. If there are multiple pairs 
satisfying these conditions, return the one with the smallest num1 value. If no 
such numbers exist, return [-1, -1].

Example 1:
Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.

Example 2:
Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions 
cannot be satisfied.
 */
class ClosePair{
    static int[] findClosestPrime(int left, int right){
        int primeCount = 0;
        boolean[] seive = new boolean[right+1];
        int[] primeNos = new int[right + 1];
        for(int i = 2; i <= right; i++){
            if(!seive[i]){
                primeNos[primeCount++] = i;
            }
            for(int  j = 0; primeNos[j] <= right/i; j++){
                seive[primeNos[j] * i] = true;
                if(i % primeNos[j] == 0) break;
            }
        }
        int firstIndex = -1, secondIndex = -1;
        for(int k = 0; k < primeCount; k++){
            if(primeNos[k] >= left && primeNos[k] <= right){
                if(firstIndex == -1) firstIndex = k;
                secondIndex = k;
            }
        }
        int[] ans = new int[] {-1, -1};
        
        if(firstIndex == secondIndex || firstIndex == -1) return ans;
        int minDist = Integer.MAX_VALUE;
        for(int k = firstIndex; k < secondIndex; k++){
            int distance = primeNos[k+1] - primeNos[k];
            if(distance < minDist){
                minDist = distance;
                ans[0] = primeNos[k];
                ans[1] = primeNos[k+1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int left = 10;
        int right = 19;
        int[] ans = findClosestPrime(left, right);
        System.out.println(ans[0] + " : " + ans[1]);
    }
}