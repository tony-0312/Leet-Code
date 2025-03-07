class ClosePair{
    public static void main(String[] args) {
        int left = 10;
        int right = 19;
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
        int firstIndex = -1, secondInd = -1;
    }
}