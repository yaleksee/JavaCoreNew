package src.less11;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test5 {
    public static void main(String[] args) {
        List list = Arrays.asList(50, 40, 30, 100, 120, 110, 150);
        Map<String, String> map = new HashMap();
        map.put("1", "new");
        map.put("2", "new");
        map.put("3", "new");
        map.put("4", "new");
        map.put("5", "new");

        int[] arr = {50, 40, 30, 100, 120, 110, 150};
        int count = 0;

        for (int x : arr) {
            if (x >= 90) continue;
            x += 10;
            count++;
            if (count > 3) break;
            System.out.println(x);
        }

        IntStream.of(50, 40, 30, 100, 120, 110, 150).filter(x -> x < 90).map(x -> x + 10).limit(3).forEach(System.out::println);

        Stream.empty();
        list.stream();
        map.entrySet().stream();
        Arrays.stream(arr);
        Stream.of(50, 40, 30, 100, 120, 110, 150);


        List<String> strings = new ArrayList<>();
        strings.add("One");
        strings.add("Ten");
        Stream stream = strings.stream();
        stream.filter(x -> x.toString().length() == 2).forEach(System.out::println);
        strings.stream().filter(x -> x.toString().length() == 2).forEach(System.out::println);

    }
}
