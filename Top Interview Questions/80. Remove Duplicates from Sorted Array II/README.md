# Remove Duplicates from Sorted Array II

## Problem Description
Given a sorted array `nums`, remove the duplicates in-place such that duplicates appeared at most twice, and return the new length.

Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

## Approach
The provided solution utilizes a two-pointer approach to remove duplicates from the sorted array while allowing duplicates to appear at most twice:
1. Initialize two pointers, `write` and `read`, with `write` starting at index 0 and `read` starting at index 1.
2. Initialize a variable `ct` to keep track of the count of consecutive duplicates encountered.
3. Iterate through the array using the `read` pointer.
4. If the element at `nums[read]` is equal to the element at `nums[write]`, increment the count `ct`.
    - If `ct` is less than 2, swap the element at `nums[write + 1]` with the element at `nums[read]`, and then increment both `write` and `read`.
    - If `ct` is equal to 2, do not swap elements; simply increment `read`.
5. If the element at `nums[read]` is not equal to the element at `nums[write]`, reset `ct` to 0, swap the element at `nums[write + 1]` with the element at `nums[read]`, and then increment both `write` and `read`.
6. Repeat steps 3 to 5 until `read` reaches the end of the array.
7. Finally, return `write + 1`, which represents the new length of the modified array without duplicates.

## Time Complexity
The time complexity of this solution is O(n), where n is the length of the input array `nums`. This is because the algorithm iterates through each element of the array once. Swapping elements and incrementing pointers are constant-time operations.

Thus, the solution efficiently removes duplicates from the sorted array while allowing duplicates to appear at most twice, all in-place without requiring any extra space.
