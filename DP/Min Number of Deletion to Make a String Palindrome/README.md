# Min Number of Deletion to Make a String Palindrome

The solution for the problem is straight-forward, all you have to do is find the Maximum Palindromic Subsequence and subtract that from the String Length.
The below solution shows how to get the Maximum Palindromic Subsequence.



## Problem Description
Given a string `s`, find the length of the longest palindromic subsequence in `s`. A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements. A palindromic sequence is a sequence that reads the same backward as forward.

For example, given the string `s = "bbbab"`, the longest palindromic subsequence is "bbbb", with a length of 4.

### Problem Link
[Longest Palindromic Subsequence - LeetCode](https://leetcode.com/problems/longest-palindromic-subsequence/)

## Approach
We can solve this problem using dynamic programming. We'll define a 2D array `dp` where `dp[i][j]` represents the length of the longest palindromic subsequence in the substring `s[i...j]`. We'll initialize the array with zeros.

We'll iterate through the string `s` and fill the `dp` array accordingly. If the characters at positions `i` and `len - j` are the same, then the length of the longest palindromic subsequence including these characters will be `dp[i-1][j-1] + 1`. Otherwise, we'll take the maximum of the lengths of the palindromic subsequences obtained by excluding either the character at position `i` or at position `j`.

Finally, the length of the longest palindromic subsequence in the entire string `s` will be stored in `dp[len][len]`.

## Implementation
```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];

        for(int i = 1 ; i <= len ; i++){
            for(int j = 1 ; j <= len ; j++){
                if(s.charAt(i-1) == s.charAt(len - j))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[len][len];
    }
}
```

## Time Complexity
Let `n` be the length of the input string `s`. 
- The time complexity of the dynamic programming solution is O(n^2) because we are iterating through the string `s` of length `n` twice.
- Thus, the overall time complexity of the solution is O(n^2).

## Space Complexity
- The space complexity of the solution is O(n^2) because we are using a 2D array `dp` of size `(n+1) x (n+1)` to store the intermediate results.
- Additionally, there are some additional variables which occupy constant space.
- Thus, the overall space complexity of the solution is O(n^2).
