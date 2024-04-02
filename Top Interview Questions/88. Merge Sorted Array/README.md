# Merge Sorted Array

## Problem Description
Given two sorted integer arrays `nums1` and `nums2`, merge `nums2` into `nums1` as one sorted array. 

Note:
- The number of elements initialized in `nums1` and `nums2` are `m` and `n` respectively.
- You may assume that `nums1` has a size equal to `m + n` such that it has enough space to hold additional elements from `nums2`.

## Approach
The provided solution utilizes a simple approach:
1. Initialize an index `idx` to the length of `nums1` where `nums2` should be merged.
2. Iterate through each element in `nums2`.
3. Append each element of `nums2` to `nums1` starting from index `idx`.
4. Sort the merged `nums1` array.

## Time Complexity
The time complexity of the solution primarily depends on two factors:
- Copying `nums2` into `nums1` takes O(n) time, where n is the number of elements in `nums2`.
- Sorting the merged array using `Arrays.sort()` takes O((m + n) log(m + n)) time.

Thus, the overall time complexity of the solution is O((m + n) log(m + n)), where m is the number of elements initialized in `nums1` and n is the number of elements in `nums2`.

This solution works well for small input sizes. However, for larger input sizes, particularly when m and n are significantly large, a more efficient approach that directly merges the arrays without using additional space or sorting can be implemented to achieve better time complexity.
