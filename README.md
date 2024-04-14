[![LeetCode Flowchart](https://leetcode.com/explore/interview/card/cheats…20/resources/Figures/DSA/Chapter_11/flowchart.png)](https://leetcode.com/explore/interview/card/cheats…20/resources/Figures/DSA/Chapter_11/flowchart.png)

[![Time Comlexity](https://leetcode.com/explore/interview/card/cheats…/720/resources/Figures/DSA/Chapter_11/sorting.png)](https://leetcode.com/explore/interview/card/cheats…/720/resources/Figures/DSA/Chapter_11/sorting.png)

### Important TC Computation :
- To Find Permutation of n-length Array : O(n * n!)

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



### Priority Queue (Min Heap and Max Heap) in Java

#### Min Heap

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
```
By default, the PriorityQueue in Java is a Min Heap. It orders the elements in natural order (ascending order for integers).

#### Max Heap

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
```
Alternatively, you can create a Max Heap using a custom comparator where we compare `b` with `a` instead of `a` with `b`.


### Initiating a MashMap with Values

```java
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Character, String> map = Map.of(
            '2' , "abc",
            '3' , "def",
            '4' , "ghi",
            '5' , "jkl",
            '6' , "mno",
            '7' , "pqrs",
            '8' , "tuv",
            '9' , "wxyz"
        );
    }
}
```

### Inline Comparator to Sort Strings on Length

```java
import java.util.Arrays;

public class StringSortExample {
    
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "grape", "orange", "kiwi"};
        
        Arrays.sort(strings, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        // Print sorted strings
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
```

### Implement the Prefix Tree

```java
class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch , new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for (int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                node = node.get(ch);
            }
            else{
                return null;
            }
        }

        return node; 
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

}

class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch , TrieNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

```
