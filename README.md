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


### Union By Rank 

```java
// UnionFind.class
class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; 
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}

// App.java
// Test Case
public class App {
    public static void main(String[] args) throws Exception {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }
}
```

Time Complexity : 
- Construct : O(N)
- Find/Union/Connected: O(α)
- N is the number of vertices in the graph. α refers to the Inverse Ackermann function. In practice, we assume it's a constant. In other words, O(α) is regarded as O(1) on average.


# Tree to Undirected Graph Conversion Function

This function, `makeTree`, converts a binary tree into an undirected graph. The function takes in four parameters: the previous node, the current node, a map representing the graph, and a set of leaf nodes. It recursively traverses the tree and constructs an undirected graph while also identifying and collecting the leaf nodes.

## Function Signature

```java
public void makeTree(TreeNode prevNode, TreeNode currNode, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leafNodes)
```

## Parameters

- `TreeNode prevNode`: The previous node in the traversal. Initially, this can be set to `null`.
- `TreeNode currNode`: The current node being visited.
- `Map<TreeNode, List<TreeNode>> graph`: A map representing the graph where each node is mapped to a list of its connected nodes.
- `Set<TreeNode> leafNodes`: A set to collect all the leaf nodes in the tree.

## How It Works

1. **Base Case**: If the current node (`currNode`) is `null`, the function returns without doing anything.
2. **Leaf Node Check**: If the current node has no left or right children, it is identified as a leaf node and added to the `leafNodes` set.
3. **Graph Construction**: 
   - If the previous node (`prevNode`) is not `null`, the function updates the graph:
     - It ensures that an entry exists for `prevNode` in the graph and adds `currNode` to its list of connected nodes.
     - It ensures that an entry exists for `currNode` in the graph and adds `prevNode` to its list of connected nodes.
4. **Recursive Traversal**: The function recursively calls itself for the left and right children of the current node.

## Example Usage

Here is an example of how you might use the `makeTree` function:

```java
TreeNode root = // initialize your tree
Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
Set<TreeNode> leafNodes = new HashSet<>();

makeTree(null, root, graph, leafNodes);

// Now `graph` contains the undirected graph representation of the tree
// and `leafNodes` contains all the leaf nodes of the tree
```

## Notes

- This function assumes that the `TreeNode` class is already defined and that the tree structure is properly initialized before calling `makeTree`.
- The `graph` parameter should be an empty map when passed to the function, and the `leafNodes` parameter should be an empty set.
- The function uses the `computeIfAbsent` method to ensure that a node's adjacency list is initialized if it is not already present in the graph.

By following the above steps, the `makeTree` function effectively converts a binary tree into an undirected graph, while also identifying and collecting all the leaf nodes in the tree.
