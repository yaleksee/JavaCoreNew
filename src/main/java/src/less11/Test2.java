package src.less11;

import java.util.Arrays;
import java.util.Collection;

public class Test2 {
    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> System.out.println(s));
    }
}
