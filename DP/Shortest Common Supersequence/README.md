# Problem: Shortest Common Supersequence

Given two strings `X` and `Y`, we need to find the length of the shortest common supersequence of the two strings. A supersequence of a string is a sequence that contains both strings as subsequences.

## Example:

**Input:**
```
X = "geek"
Y = "eke"
```

**Output:**
```
5
```

**Explanation:**
The shortest common supersequence is "geeke" which has a length of 5.

## Approach:

We can solve this problem using dynamic programming. Let's define a 2D array `dp` of size `(m+1) x (n+1)`, where `m` and `n` are the lengths of strings `X` and `Y` respectively. Each cell `dp[i][j]` will represent the length of the shortest common supersequence of substrings `X[0...i-1]` and `Y[0...j-1]`.

1. Initialize the dp array with dimensions `(m+1) x (n+1)`.
2. Iterate over each cell of the dp array.
3. If either of the strings is empty (i.e., `i=0` or `j=0`), then the length of the shortest common supersequence would be the length of the other string.
4. If the characters at the current indices `i` and `j` match, we add 1 to the length of the shortest common supersequence obtained from the previous characters `dp[i-1][j-1]`.
5. If the characters don't match, we consider two cases:
   - We include the current character from string `X`, and the shortest common supersequence will be `1 + dp[i-1][j]`.
   - We include the current character from string `Y`, and the shortest common supersequence will be `1 + dp[i][j-1]`.
   - We take the minimum of the above two cases.
6. Finally, return `dp[m][n]`, which represents the length of the shortest common supersequence of strings `X` and `Y`.

## Implementation:

```java
class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X, String Y, int m, int n)
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
```

## Complexity Analysis:

- **Time Complexity:** O(m * n), where m and n are the lengths of strings X and Y respectively.
- **Space Complexity:** O(m * n), where m and n are the lengths of strings X and Y respectively.
