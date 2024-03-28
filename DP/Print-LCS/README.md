# Longest Common Subsequence

## Problem Description
Given two strings `s1` and `s2`, find the longest common subsequence (LCS) and return it. If there are multiple LCS with the same length, return any one of them.

A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, `"abc"`, `"abg"`, `"bdf""avc"` are subsequences of `"abcdefg"`.

## Example

**Input:**
```
s1 = "abcde"
s2 = "ace"
```

**Output:**
```
"ace"
```
Explanation: The longest common subsequence is "ace" which has a length of 3.

**Input:**
```
s1 = "abc"
s2 = "abc"
```

**Output:**
```
"abc"
```
Explanation: Both strings are identical, so the longest common subsequence is "abc" itself.

## Constraints
- The input strings `s1` and `s2` consist of lowercase English letters.
- Length of both strings will not exceed 1000.

## Approach
To find the longest common subsequence between two strings, we can use dynamic programming. We'll create a 2D array `dp` where `dp[i][j]` represents the longest common subsequence of `s1` up to index `i` and `s2` up to index `j`. We initialize this array with empty strings.

We iterate through the strings `s1` and `s2` using nested loops. At each position `(i, j)`, if the characters `s1[i]` and `s2[j]` match, we extend the LCS by appending the character to the LCS of `s1` up to index `i-1` and `s2` up to index `j-1`. If they don't match, we choose the longer LCS between `s1` up to index `i-1` and `s2` up to index `j`, or `s1` up to index `i` and `s2` up to index `j-1`.

Finally, we return the LCS found at `dp[n][m]`, where `n` and `m` are the lengths of `s1` and `s2` respectively.

## Implementation
```java
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
```

This solution utilizes dynamic programming to efficiently find the longest common subsequence between two given strings.
