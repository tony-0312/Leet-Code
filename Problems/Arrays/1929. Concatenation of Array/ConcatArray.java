class ConcatArray{
    static void concatenationArray(int[] nums){
        int size = nums.length;
        int[] ans = new int[size * 2];
        for(int i = 0; i < size; i++){
            ans[i] = nums[i];
            ans[i+size] = nums[i];
        }
        for(int num : ans){
            System.out.print(num + " ");
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,3,2,1};
        concatenationArray(nums);
        
    }
}