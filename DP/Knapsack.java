import java.util.*;

public class Solution {
	static int[][] dp;
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		dp = new int[n + 1][w + 1];

		for(int i = 0 ; i <= n ; i++){
			for(int j = 0 ; j <= w ; j++){
				if(i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for(int i = 1 ; i <= n ; i++){
			for(int j = 1 ; j <= w ; j++){

				if(weights.get(i-1) <= j){
					dp[i][j] = Math.max(values.get(i-1) + dp[i-1][j - weights.get(i-1)] , dp[i-1][j] );
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n][w];



		// for(int[] p : dp){
		// 	Arrays.fill(p , -1);
		// }

		// func(values, weights, w , n);
		// return dp[n][w];
	}

	public static int func(ArrayList<Integer> v, ArrayList<Integer> w, int tW, int idx ){

		if(tW == 0 || idx == 0)
			return 0;

		if(dp[idx][tW] != -1)
			return dp[idx][tW];

		if(w.get(idx-1) <= tW){
			dp[idx][tW] = Math.max(v.get(idx-1) + func(v , w , tW - w.get(idx - 1) , idx -1) , func(v , w , tW , idx - 1));
		}
		else{
			dp[idx][tW] = func(v , w , tW , idx - 1);
		}

		return dp[idx][tW];

	}
}
