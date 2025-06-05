class Single{
	
	static int singleNumber(int[] nums){
		int single = 0;
		
		for(int i = 0; i < nums.length; i++){
			single ^= nums[i];
		}
		
		return single;
	}
	
	public static void main(String[] args){
		int[] nums = {2, 2, 1};
		System.out.println(singleNumber(nums));
	}
}