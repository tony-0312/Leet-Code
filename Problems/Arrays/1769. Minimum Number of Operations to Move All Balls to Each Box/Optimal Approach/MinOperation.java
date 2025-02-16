class MinOperation{
    static int[] findMinOperation(String boxes){
        int size = boxes.length();
        int[] left = new int[size];
        int[] right = new int[size];
        for(int i = 1,count = 0; i < size; i++){
            if(boxes.charAt(i-1) == '1') count++;
            left[i] = left[i-1] + count;
        }
        for(int i = size - 2,count = 0; i >= 0; i--){
            if(boxes.charAt(i+1) == '1') count++;
            right[i] = right[i+1] + count;
        }
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = left[i] + right[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        String boxes = "001011";
        int[] ans = findMinOperation(boxes);
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
}