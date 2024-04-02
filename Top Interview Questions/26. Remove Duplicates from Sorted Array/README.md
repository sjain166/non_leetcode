# Remove Duplicates from Sorted Array

## Problem Description
Given a sorted array `nums`, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

## Approach
The provided solution utilizes a two-pointer approach to remove duplicates from the sorted array:
1. Initialize two pointers, `read` and `write`, both pointing to the start of the array.
2. Iterate through the array using the `read` pointer.
3. If the element at `nums[write]` is equal to the element at `nums[read]`, increment `read` to skip over that duplicate element.
4. If the element at `nums[write]` is not equal to the element at `nums[read]`, swap the element at `nums[write + 1]` with the element at `nums[read]`, and then increment both `read` and `write`.
5. Repeat steps 3 and 4 until `read` reaches the end of the array.
6. Finally, return `write + 1`, which represents the new length of the modified array without duplicates.

## Time Complexity
The time complexity of this solution is O(n), where n is the length of the input array `nums`. This is because the algorithm iterates through each element of the array once. Swapping elements and incrementing pointers are constant-time operations.

Thus, the solution efficiently removes duplicates from the sorted array in-place without requiring any extra space.
