package src.less10;

import java.util.Arrays;
import java.util.List;

public class GenMethodDemo {
    public static <T, V> boolean isIn(T x, V[] array) {
        List<V> vList = Arrays.asList(array);
        return vList.contains(x);
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Integer[] integers1 = {1, 2, 3, 4, 5};
        if (isIn(2, integers)) {
            System.out.println("true");
        }
        if (isIn(20, integers1)) {
            System.out.println("no");
        }

        String[] strings = {"a", "s", "d"};
        if (isIn("a", strings)) {
            System.out.println("true");
        }
        if (isIn("20", strings)) {
            System.out.println("no");
        }
    }
}
