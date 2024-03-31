class Solution {
    int dp[];
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int robLast = func(nums , nums.length , 1);

        Arrays.fill(dp, -1);
        int robFirst = func(nums , nums.length - 1 , 0);

        return Math.max(robLast , robFirst);
    }

    public int func(int[] nums , int idx , int end){
        if(idx <= end)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        return dp[idx] = Math.max(nums[idx - 1] + func(nums , idx - 2 , end) , func(nums , idx -1 , end));
        
    }

    
}
