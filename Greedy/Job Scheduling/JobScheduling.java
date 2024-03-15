
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
