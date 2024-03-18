class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0 , len = arr.length;
        for (int i : arr){
            sum += i;
        }
        if(sum < 0)
            return -1;

        boolean[][] dp = new boolean[len + 1][sum + 1];
        for(int i = 0 ; i <= len ; i++){
            for(int j = 0 ; j <= sum ; j++){
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }

        for(int i = 1 ; i <= len ; i++){
            for(int j = 1 ; j <= sum ; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i <= sum ; i++){
            if(dp[len][i]){
                minDiff = Math.min(minDiff , Math.abs(sum - 2*i));
            }
        }
        
        return minDiff;
	} 
	
}

// Link : https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
