# Minimum Subset Sum Difference

## Approach

The problem requires finding the minimum possible difference between the sums of two subsets of the given array. To achieve this, we can utilize dynamic programming.

1. **Calculate Total Sum**: First, calculate the total sum of all elements in the array. If the total sum is negative, it indicates that there's no way to partition the array into two subsets with equal sums, hence return -1.

2. **Subset Sum DP**: Next, we create a boolean 2D array `dp[len + 1][sum + 1]`, where `len` is the length of the array and `sum` is the total sum. `dp[i][j]` represents whether it's possible to form a subset with sum `j` using the first `i` elements of the array.

3. **Initialize DP Array**: Initialize the base cases where if the sum is 0, it's always possible to achieve it, and if there are no elements in the array, it's not possible to achieve any sum.

4. **Dynamic Programming**: Iterate through each element of the array and for each sum value from 1 to the total sum. Update `dp[i][j]` based on whether it's possible to include the current element in the subset sum to reach `j`.

5. **Find Minimum Difference**: After completing the DP table, iterate through the last row of the DP array to find the sums that are achievable. For each achievable sum `i`, calculate the absolute difference between the total sum and twice the current sum `Math.abs(sum - 2*i)` and update the minimum difference found so far.

6. **Return Minimum Difference**: After the iteration, return the minimum difference found.

## Time Complexity

- Calculating the total sum takes O(n) time, where n is the number of elements in the array.
- Constructing the DP table takes O(n*sum) time, where `sum` is the total sum of the array. This is because for each element, we're iterating through `sum`.
- Finding the minimum difference takes O(sum) time, where `sum` is the total sum.
  
Overall, the time complexity of the solution is O(n*sum), where n is the number of elements in the array and sum is the total sum of the array.

---
By focusing on dynamic programming, we efficiently solve this problem in polynomial time. The README provides a clear understanding of the approach and the associated time complexity.
