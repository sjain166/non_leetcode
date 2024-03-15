## LeetCode Problem: Fractional Knapsack Problem

### Problem Description
You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).

### Input
- The first line contains an integer T, the number of test cases.
- The first line of each test case contains integers N and W, the number of items and the maximum capacity of the knapsack, respectively.
- The second line of each test case contains 2*N space-separated integers representing the values and weights of items respectively.

### Output
For each test case, print the maximum total value in the knapsack with precision up to 6 decimal places.

### Example
#### Input
```
2
3 50
60 10 100 20 120 30
2 50
60 10 100 20
```

#### Output
```
240.000000
160.000000
```

### Approach
We solve this problem using the Greedy approach. We sort the items based on their value-to-weight ratio in non-increasing order. Then, starting with the item with the highest ratio, we add items to the knapsack until it reaches its maximum capacity. If there's still space left, we add a fraction of the next item. We repeat this process until the knapsack is full.

### Java Code
```java
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        //Sorting With Value/Weight for each item
        Arrays.sort(arr , new Comparator<Item>(){
           public int compare(Item a , Item b){
                int comp = Double.compare(((double)b.value/b.weight) , (double)a.value/a.weight);
                return comp;
           }
        });
        
        double value = 0;
        for(Item i : arr){
            if(W - i.weight >= 0){
                W -= i.weight;
                value += i.value;
            }
            else{
                value = value +  ((double)i.value / i.weight) * (double)W;
                break;
            }
        }
        
        return value;
    }
}
```

### Explanation
- We define a class `Item` to represent each item with its value and weight.
- The main logic is implemented in the `Solution` class's `fractionalKnapsack` method.
- We sort the items based on their value-to-weight ratio.
- We iterate through the sorted items and add them to the knapsack greedily.
- We calculate the total value considering fractions of items if necessary.
- The driver code reads input, creates objects, and calls the solution method for each test case.
