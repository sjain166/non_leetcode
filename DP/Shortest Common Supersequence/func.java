class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i == 0)
                    dp[i][j] = j;
                if(j == 0)
                    dp[i][j] = i;
            }
        }
        
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}

//Problem Link : https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
