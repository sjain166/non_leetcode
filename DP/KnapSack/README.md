### Approach 1: Recursive Solution

In this approach, we start by defining a recursive function to explore all possible combinations of items. At each step, we have two choices: either include the current item in the knapsack or exclude it. We compute the maximum profit by considering both possibilities and recursively call the function for the remaining items.

#### Steps:
1. Define a recursive function `recursiveMaxProfit()` that takes the following parameters:
   - `ArrayList<Integer> values`: List of item values.
   - `ArrayList<Integer> weights`: List of item weights.
   - `int n`: Number of items.
   - `int w`: Remaining weight capacity for the knapsack.
   - `int idx`: Current index indicating the item being considered.

2. Base Case:
   - If either `n` becomes 0 (no more items) or `w` becomes 0 (knapsack capacity exhausted), return 0.

3. Recursive Case:
   - If the weight of the current item (`weights.get(idx)`) is less than or equal to `w`, we have two choices:
     - Include the current item: `values.get(idx)` + `recursiveMaxProfit(values, weights, n - 1, w - weights.get(idx), idx + 1)`
     - Exclude the current item: `recursiveMaxProfit(values, weights, n - 1, w, idx + 1)`
   - Return the maximum of the above two choices.

#### Complexity Analysis:
- Time complexity: Exponential, as it explores all possible combinations.
- Space complexity: \(O(n)\) due to the recursion stack.

### Approach 2: Recursive Solution with Memoization

To optimize the recursive approach, we can store the results of already computed subproblems using memoization. This avoids redundant computations by caching the results of function calls for different parameters.

#### Steps:
1. Initialize a 2D array `memo[][]` to store the results of subproblems.

2. Modify the `recursiveMaxProfit()` function to check if the result for the current parameters has already been computed and stored in `memo[][]`. If so, return the cached result.

3. After computing the result for the current parameters, store it in `memo[][]`.

#### Complexity Analysis:
- Time complexity: \(O(n \times w)\), as each subproblem is solved once and stored for future use.
- Space complexity: \(O(n \times w)\) for the `memo[][]` array.

### Approach 3: Dynamic Programming (Tabulation)

This approach involves building the solution iteratively using a bottom-up approach. We fill a 2D array `dp[][]` where `dp[i][j]` represents the maximum profit that can be achieved with the first `i` items and a knapsack capacity of `j`.

#### Steps:
1. Initialize a 2D array `dp[][]` of size `(n + 1) x (w + 1)` and initialize its values to 0.

2. Iterate over all items and for each item `i`, and for each capacity `j` from 0 to `w`, calculate `dp[i][j]` as follows:
   - If the weight of the current item is less than or equal to `j`, `dp[i][j]` will be the maximum of:
     - `values.get(i-1)` + `dp[i-1][j - weights.get(i-1)]` (including the current item)
     - `dp[i-1][j]` (excluding the current item)
   - Otherwise, `dp[i][j]` will be `dp[i-1][j]`.

3. The result will be stored in `dp[n][w]`, representing the maximum profit achievable with all items and the full knapsack capacity.

#### Complexity Analysis:
- Time complexity: \(O(n \times w)\), where \(n\) is the number of items and \(w\) is the maximum weight capacity.
- Space complexity: \(O(n \times w)\) for the `dp[][]` array.
