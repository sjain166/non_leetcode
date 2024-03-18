lass Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i = 0;
        int j = 0;
        
        while(i < arr.length){
            int addValue = j < arr.length ? arr[j] : Integer.MAX_VALUE;
            q.add(addValue);
            
            if(j - i == k){
                arr[i] = q.poll();
                i++;
            }
            
            j++;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int p : arr){
            res.add(p);
        }
        
        return res;
        
    }
}

//https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
