# Remove Element

## Problem Description
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in many programming languages, you must instead have the result be placed in the first part of the array `nums`. More formally, if there are `k` elements after removing the duplicates, then the first `k` elements of `nums` should hold the final result. It does not matter what you leave beyond the first `k` elements.

Return `k` after placing the final result in the first `k` slots of `nums`.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

## Approach
The provided solution employs a two-pointer approach to solve the problem in-place:
1. Initialize two pointers: `write` and `read`, both pointing to the start of the array.
2. Iterate through the array using the `read` pointer.
3. If the element at `nums[read]` is equal to the given value `val`, increment `read` to skip over that element.
4. If the element at `nums[read]` is not equal to `val`, swap the element at `nums[read]` with the element at `nums[write]`, and then increment both `write` and `read`.
5. Repeat steps 3 and 4 until `read` reaches the end of the array.
6. Finally, return the value of `write`, which represents the new length of the modified array.

## Time Complexity
The time complexity of this solution is O(n), where n is the length of the input array `nums`. This is because the algorithm iterates through each element of the array once. Swapping elements and incrementing pointers are constant-time operations.

Thus, the solution efficiently removes the specified element from the array in-place without requiring any extra space.
