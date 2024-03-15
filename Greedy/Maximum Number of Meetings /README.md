# Maximum Number of Meetings

This problem aims to find the maximum number of meetings that can be performed in a meeting room given the start and end times of each meeting.

## Approach

We can solve this problem using a greedy approach. First, we create an array of tuples where each tuple contains the start time, end time, and the meeting number. Then, we sort this array based on the end times of the meetings. After sorting, we iterate through the sorted array, selecting meetings that do not overlap with the previous selected meetings.

## Input Format

- The first line of the input contains an integer `t`, representing the number of test cases.
- For each test case:
  - The first line contains an integer `n`, representing the number of meetings.
  - The second line contains `n` space-separated integers denoting the start times of the meetings.
  - The third line contains `n` space-separated integers denoting the end times of the meetings.

## Output Format

For each test case, output the maximum number of meetings that can be performed in a meeting room.

## Example

Input:
```
2
6
1 3 0 5 8 5
2 4 6 7 9 9
3
1 3 0
2 4 6
```

Output:
```
4
2
```

## Implementation Details

The provided Java code implements the solution. The `maxMeetings` function takes three parameters: `start`, `end`, and `n`, representing the start times, end times, and the number of meetings respectively. It returns the maximum number of meetings that can be performed.

To run the code, compile it and provide input according to the specified format. The code reads input from the standard input and prints the output to the standard output.
