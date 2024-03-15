/*

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
