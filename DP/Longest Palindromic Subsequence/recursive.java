class Solution {
    Integer dp[][];
    public int longestPalindromeSubseq(String s) {
        dp = new Integer[s.length() + 1][s.length() + 1];
        return func(s , 1 , s.length());
    }

    public int func(String s , int i , int j){
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        
        if(s.charAt(i-1) == s.charAt(j-1))
            return dp[i][j] = 2 + func(s , i + 1 , j - 1);
        else{
            return dp[i][j] = Math.max(func(s , i , j - 1) , func(s , i + 1 , j));
        }
    }
}
