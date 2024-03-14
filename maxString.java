/*

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

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
*/
// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<int[]> res = new ArrayList<>();
        for(int i = 0 ; i < start.length ; i++){
            int[] newMeet = {start[i] , end[i] , i + 1};
            res.add(newMeet);
        }
        
        Collections.sort(res , new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                int compare = Integer.compare(a[1] , b[1]);
                if(compare != 0){
                    return compare;
                }
                
                return Integer.compare(a[2] , b[2]);
            }
        });
        
        
        
        int count = 0;
        int last = Integer.MIN_VALUE;
        
        for(int[] meet : res){
            if(meet[0] > last){
                last = meet[1];
                count++;
            }
        }
        
        return count;
        
        
    }

}
