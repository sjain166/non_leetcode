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

