## Problem: House Robber II

Given a circular array of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police. Note that the houses are arranged in a circle, which means the first house is adjacent to the last house.

### Example:
```
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses. Instead, rob house 2 (money = 3).
```

### Approach:

The problem is an extension of the House Robber problem, but with a circular arrangement of houses. The circular arrangement introduces a constraint where the first and last houses cannot be robbed together. Therefore, the solution involves breaking down the problem into two cases:

1. **Robbing the last house:** In this case, we exclude the first house and consider the rest of the houses as a linear sequence. We use the same dynamic programming approach as in the House Robber problem to find the maximum amount of money that can be robbed.
2. **Robbing the first house:** In this case, we exclude the last house and consider the rest of the houses as a linear sequence. Again, we use dynamic programming to find the maximum amount of money that can be robbed.
3. We then return the maximum of the amounts obtained from the two cases.

### Time Complexity:

Let n be the number of houses.

- The dynamic programming solution has a time complexity of O(n) since each subproblem is solved only once, and there are O(n) subproblems.
- Therefore, the overall time complexity of the solution is O(n).

### Space Complexity:

- The solution uses an array `dp[]` of size O(n) to store the results of subproblems.
- Thus, the space complexity of the solution is O(n).
