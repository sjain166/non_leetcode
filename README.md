[![LeetCode Flowchart](https://leetcode.com/explore/interview/card/cheats…20/resources/Figures/DSA/Chapter_11/flowchart.png)](https://leetcode.com/explore/interview/card/cheats…20/resources/Figures/DSA/Chapter_11/flowchart.png)

[![Time Comlexity](https://leetcode.com/explore/interview/card/cheats…/720/resources/Figures/DSA/Chapter_11/sorting.png)](https://leetcode.com/explore/interview/card/cheats…/720/resources/Figures/DSA/Chapter_11/sorting.png)

### Convert a Array to HashSet

```java
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        System.out.println(vowels);
    }
}
```

### Remove Trailing Spaces Using `String.trim()` method:

```java
String str = "  Hello World   ";
String trimmed = str.trim();
System.out.println(trimmed); // Output: "Hello World"
```

### Sliding Window Pattern

```java
int left = 0;
int right = 0;
int len = nums.length;
double avg = Integer.MIN_VALUE;
double sum = 0;

while(right < len){
    sum += nums[right++];
    if(right - left == k){
        avg = Math.max(sum / k , avg);
        sum -= nums[left++];
    }
}

return avg;
```


### HashMap Iteration Techniques

#### Using forEach() method

The `forEach()` method allows iterating over the elements of a HashMap using a lambda expression. It takes a BiConsumer functional interface as a parameter, which accepts two arguments: the key and the value of the HashMap entry.

Example:
```java
charType.forEach((key, value) -> System.out.println(key + " = " + value));
```

#### Using entrySet() method with for-each loop

The `entrySet()` method returns a set view of the mappings contained in the HashMap. By using this method with a for-each loop, you can iterate over each entry of the HashMap.

Example:
```java
for (Map.Entry<String, String> entry : foodTable.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

### Converting Each Row of Grid to String and Hashing

```java
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        // Keep track of the frequency of each row.
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
        }

        // Add up the frequency of each column in map.
        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; ++r) {
                colArray[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
        }

        return count;
    }
}
```

