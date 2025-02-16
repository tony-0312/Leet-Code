class MinOpeations{
    static int[] findMinOperations(String box){
        int size = box.length();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(box.charAt(j) == '1'){
                    ans[i] += Math.abs(i-j);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String box = "001011";
        int[] ans = findMinOperations(box);
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}