package src.less11;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(99, 50, 2).collect(Collectors.toList());


        Set<Integer> set = Stream.of(99, 50, 2).collect(Collectors.toSet());

        Long count = Stream.of("1", "3", "5", "7").collect(Collectors.counting());


    }
}
