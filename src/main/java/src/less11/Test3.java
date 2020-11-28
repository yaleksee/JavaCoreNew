package src.less11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Test3 {
    public static void main(String[] args) {
//        Predicate<Integer> isEvenNumber = x -> x % 2 == 0;
//        System.out.println(isEvenNumber.test(4));
//        System.out.println(isEvenNumber.test(3));


//        Consumer greeting = x -> System.out.println("!!!" + x + " !!! ");
//        greeting.accept(" YOTA ");
//
//        List nameList = new ArrayList<>();
//        nameList.add("1");
//        nameList.add("2");
//        nameList.add("3");
//        nameList.add("4");
//        nameList.add("5");
//        nameList.add("6");
//        nameList.add("7");
//
//        Supplier randomNumber = () -> {
//            int value = (int) (Math.random() * nameList.size());
//            return nameList.get(value);
//        };
//
//        System.out.println(randomNumber.get());

        Function valueConverter = x -> new Integer(x.toString());
        System.out.println(valueConverter.apply("555"));

        UnaryOperator squareValue = x -> (Integer) x * (Integer) x;
        System.out.println(squareValue.apply(10));
    }
}
