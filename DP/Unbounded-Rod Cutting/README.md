**Problem Statement:**

**Problem Name:** Cut Rod  
**LeetCode Problem ID:** (Insert LeetCode problem ID here)  
**Difficulty:** (Insert difficulty level here)  

**Problem Description:**  
You are given a rod of length `n` and an array `price[]` where `price[i]` represents the price of a rod of length `i+1`. You want to cut the rod into smaller rods to maximize the profit. Write a function `cutRod` to find the maximum profit you can achieve by cutting the rod and selling the pieces.

**Example:**  
Input: `price[] = {1, 5, 8, 9, 10, 17, 17, 20}, n = 8`  
Output: `22`  
Explanation: The maximum profit can be achieved by cutting the rod into pieces of length 2 and 6, giving a total profit of 22 (5 + 17).

**Approach:**

1. **Dynamic Programming (Bottom-Up Approach):**  

   - Initialize a 2D array `dp[][]` of dimensions `(price.length + 1) x (n + 1)`.
   - Base case: For `i = 0` or `j = 0`, `dp[i][j]` is set to `0` (no length or no rod to cut, hence profit is 0).
   - Iterate over the rod lengths (`i`) and the total length (`j`).
   - For each cell `(i, j)`:
     - If `i <= j`, it means we can cut a rod of length `i+1` from the rod of length `j`. We compare the profit of cutting and not cutting the rod and take the maximum.
     - If `i > j`, it means the current rod length is longer than the length we need to cut. So, we cannot cut it, and we take the profit from the previous length.
   - Finally, return `dp[price.length][n]`, which holds the maximum profit achievable by cutting the rod.

**Time Complexity Analysis:**

- The time complexity of the dynamic programming approach is `O(n^2)`, where `n` is the length of the rod. This is because we have a nested loop iterating from 1 to `n` twice.

**Space Complexity Analysis:**

- The space complexity of the dynamic programming approach is also `O(n^2)`, as we are using a 2D array of dimensions `(price.length + 1) x (n + 1)` to store intermediate results.

**Note:**  
Make sure to replace `(Insert LeetCode problem ID here)` and `(Insert difficulty level here)` with the actual LeetCode problem ID and difficulty level once identified.
