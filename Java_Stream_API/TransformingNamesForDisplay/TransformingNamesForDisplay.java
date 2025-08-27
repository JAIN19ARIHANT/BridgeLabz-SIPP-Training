import java.util.*;
public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("john", "alice", "bob", "zara", "amelia");
        System.out.println("Names in uppercase sorted alphabetically:"); 
        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
