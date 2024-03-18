**LeetCode Problem: Sort an Almost Sorted Array**

**Problem Description:**
Given an array `arr` of integers and an integer `k`, where each element in the array is at most `k` positions away from its sorted position, return the array sorted in non-decreasing order.

**Function Signature:**
```
ArrayList<Integer> nearlySorted(int arr[], int num, int k)
```

**Input:**
- `arr`: An array of integers (1 <= arr.length <= 10^5), where the absolute value of each element is at most 10^5.
- `num`: The number of elements in the array.
- `k`: An integer representing the maximum distance each element is away from its sorted position (0 <= k <= num).

**Output:**
- A sorted array in non-decreasing order.

**Example:**
```
Input: arr = [6, 5, 3, 2, 8, 10, 9], num = 7, k = 3
Output: [2, 3, 5, 6, 8, 9, 10]
Explanation: The sorted array will be [2, 3, 5, 6, 8, 9, 10] where each element is at most 3 positions away from its sorted position.
```

**Approach:**
- We use a PriorityQueue to efficiently retrieve the minimum element within a window of size `k+1`.
- We iterate over the array and at each step, we add the next element to the PriorityQueue.
- If the size of the PriorityQueue exceeds `k+1`, we remove the smallest element which is guaranteed to be at most `k` positions away from its sorted position.
- We keep track of the index range of the window, and as soon as it reaches size `k+1`, we replace the element at the start of the window with the minimum element in the PriorityQueue.
- Finally, we return the sorted array.

**Complexity Analysis:**
- Time Complexity: O(n * log(k)), where n is the number of elements in the array and log(k) is the time complexity of PriorityQueue operations.
- Space Complexity: O(k), for the PriorityQueue.
