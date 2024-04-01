class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int len = str.length();
        int[][] dp = new int[len + 1][len + 1];
        for(int i = 1 ; i <= len ; i++){
            for(int j = 1 ; j <= len ; j++){
                if(str.charAt(i-1) == str.charAt(j-1) && i != j){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[len][len];
    }
}
