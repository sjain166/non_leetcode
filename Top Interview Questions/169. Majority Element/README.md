# Majority Element

## Problem Description
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exists in the array.

## Approach
The provided solution sorts the array and then returns the element at index `n/2`, assuming that the majority element always exists in the array. This solution exploits the fact that the majority element occurs more than ⌊ n/2 ⌋ times, and thus it will be located at index `n/2` after sorting.

1. Sort the given array `nums`.
2. Return the element at index `nums.length/2`, which represents the majority element.

## Time Complexity
The time complexity of this solution primarily depends on the sorting algorithm used. Assuming an efficient sorting algorithm like quicksort or mergesort is used, the time complexity for sorting the array is O(n log n), where n is the size of the input array `nums`.
After sorting, accessing the element at index `nums.length/2` takes constant time.

Thus, the overall time complexity of the solution is O(n log n), where n is the size of the input array `nums`. This solution efficiently finds the majority element in the array by sorting it and accessing the middle element.
