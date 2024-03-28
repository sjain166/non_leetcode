public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        StringBuilder[][] dp = new StringBuilder[n + 1][m + 1];

        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= m ; j++){
                dp[i][j] = new StringBuilder("");
            }
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1].append(s1.charAt(i-1));
                }
                else{
                    if(dp[i-1][j].length() >= dp[i][j-1].length()){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }

        return dp[n][m].toString();
    }
}

// Problem Link : https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=SUBMISSION
