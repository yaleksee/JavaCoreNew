package src.less10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        Number number = Integer.valueOf(10);

        List<Number> aList = new ArrayList<>();

        Collection<Number> collection = aList;

        Iterable<Number> iterable = collection;


        /**
         * ковариантность
         * Множество<Животные> = Множество<Кошки>
         *
         * контрвариантность
         * Множество<Кошки> = Множество<Животные>
         *
         *
         */

        String[] strings = new String[]{"a", "s", "d"};
        Object[] objects = strings; // Множество<Животные> = Множество<Кошки>
        objects[0] = 42; // error

        List<Integer> integers = Arrays.asList(1,2,3,4,5);
//        List<Number> numbers = integers;


        List<Integer> ints = new ArrayList<Integer>();
        List<? extends Number> numbers = ints;


        List<Number> nums = new ArrayList<Number>();
        List<? super Integer> list = nums;

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(1);
        integerList.add(2);

        List<? extends Number> numbers1 = integerList;
//        numbers1.add(123);
        numbers1.get(0);

    }

    public static <T> T getF(List<? extends T> list1){

        return list1.get(0);
    }



}
