class MaxCount{
    static int maximumCount(int[] nums){
        int oneCounts = nums.length - findOccurence(nums, 1);
        int zeroCounts = findOccurence(nums, 0);
        return Math.max(oneCounts, zeroCounts);
    }
    
    static int findOccurence(int[] nums, int x){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] >= x){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,1,2};
        System.out.println(maximumCount(nums));
    }
}