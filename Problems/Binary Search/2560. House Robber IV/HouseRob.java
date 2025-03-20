class HouseRob{
	
	static int minMoneyRobbed(int[] nums, int k){
		int minMoney = Integer.MAX_VALUE;
		for(int i = 0, j = 1; i < nums.length && j < nums.length; i=i+2, j=j+2){
			int temp = Math.max(nums[i], nums[j]);
			minMoney = Math.min(minMoney, temp);
		}
		return minMoney;
	}
	
	public static void main(String[] args){
		int[] nums = {2,3,5,9};
		int k = 2;
		System.out.println(minMoneyRobbed(nums, k));
	}
}