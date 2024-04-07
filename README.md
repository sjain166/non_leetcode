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
