/*

# Job Scheduling with Deadline

This repository contains the solution for the "Job Scheduling with Deadline" problem on LeetCode.

## Problem Description

Given a set of jobs where each job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1. The task is to find the maximum profit and the number of jobs done.

## Approach

The problem can be solved by sorting the jobs in descending order of their profits. Then, for each job, starting from the job with the highest profit, we try to find the latest possible slot before the deadline to schedule the job. If such a slot is found, we schedule the job and update the profit and the number of jobs done.

## Input Format

The input consists of multiple test cases. Each test case begins with an integer **t**, denoting the number of test cases. For each test case:
- The first line contains an integer **n**, indicating the number of jobs.
- The second line contains **n** space-separated integers representing the id, deadline, and profit of each job.

## Output Format

For each test case, the output should contain two integers separated by space:
- Maximum number of jobs done.
- Maximum profit earned.

## Running the Code

To run the code, execute the `GfG.java` file. Input for the test cases can be provided via standard input (console). The output will be printed to the console as well.

## Example

**Input:**
```
2
4
1 4 20 2 1 10 3 1 40 4 1 30
5
1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
```

**Output:**
```
2 60
2 127
```

## Note

In the first test case, jobs 3 and 1 can be scheduled within their deadlines, resulting in a maximum profit of 60.

*/


//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr , new Comparator<Job>(){
           public int compare(Job a , Job b){
               int cp = Integer.compare(b.profit, a.profit);
               int cd = Integer.compare(b.deadline , a.deadline);
               
               if(cp != 0)
                return cp;
                
               if(cd != 0)
                return cd;
                
                return Integer.compare(b.id , a.id);
           }
        });
        
        int maxD = Integer.MIN_VALUE;
        for(Job j : arr){
            maxD = Math.max(j.deadline , maxD);
        }
        
        int[] seq = new int[maxD + 1];
        Arrays.fill(seq , -1);
        int profit = 0;
        int jobs = 0;
        
        for(Job j : arr){
            int idx = j.deadline;
            
            while(idx >= 1 && seq[idx] != -1){
                idx--;
            }
            
            if(idx >= 1){
                profit += j.profit;
                seq[idx] = j.id;
                jobs++;
            }
        }
        
        return new int[]{jobs , profit};
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
