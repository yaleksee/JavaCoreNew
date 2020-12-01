package src.less11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        List evenNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        List people = Stream.of("P1", "P2", "P3", "P4", "P5")
                .filter(x -> x.contains("1"))
                .peek(x -> System.out.println(x))
                .collect(Collectors.toList());

        List nameList = new ArrayList<>();
        nameList.add("1");
        nameList.add("2");
        nameList.add("3");
        nameList.add("4");
        nameList.add("5");
        nameList.add("6");
        nameList.add("7");

        Stream.generate(() -> {
            int value = (int) (Math.random() * nameList.size());
            return nameList.get(value);
        }).limit(3).forEach(System.out::println);

        List values = Stream.of("23", "56", "456", "234", "1")
                .map(x -> Integer.valueOf(x)).collect(Collectors.toList());

        Stream.iterate(10, x -> x * x)
                .limit(4)
                .forEach(System.out::println);
    }
}
