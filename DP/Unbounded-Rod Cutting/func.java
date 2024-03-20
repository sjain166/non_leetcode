class Solution{
    public int cutRod(int price[], int n) {
        int[][] dp = new int[price.length + 1][n + 1];
        
        for(int i = 0 ; i <= price.length ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        
        for(int i = 1 ; i <= price.length ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i <= j){
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-i] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[price.length][n];
    }
}

//Problem Link : https://www.geeksforgeeks.org/problems/rod-cutting0840/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
