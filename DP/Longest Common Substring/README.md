# Longest Common Substring

This problem involves finding the length of the longest common substring between two given strings.

## Problem Description

Given two strings `S1` and `S2`, find the length of the longest common substring between them.

### Example

Input:
```
S1 = "ABCDGH"
S2 = "ACDGHR"
```

Output:
```
4
```

Explanation: The longest common substring is "CDGH" of length 4.

You can find the full problem description [here](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article).

## Solution Approach

The given solution utilizes dynamic programming to solve the problem efficiently.

1. Create a 2D array `dp` of size `(n+1) x (m+1)` where `n` and `m` are the lengths of `S1` and `S2` respectively. Initialize all elements of this array to 0.
2. Traverse through both strings using two nested loops, comparing characters at corresponding positions.
3. If the characters match, set `dp[i][j] = 1 + dp[i-1][j-1]`.
4. Iterate through the `dp` array to find the maximum value, which represents the length of the longest common substring.
5. Return this maximum value.

### Implementation

```java
class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int max = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}
```

This implementation finds the length of the longest common substring between `S1` and `S2` in `O(n * m)` time complexity, where `n` and `m` are the lengths of the input strings.
