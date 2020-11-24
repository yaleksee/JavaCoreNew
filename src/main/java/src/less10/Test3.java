package src.less10;

import java.util.*;

public class Test3 {
    // PECS

    ArrayList arrayList = new ArrayList(); // Raw

    public static void main(String[] args) {
        List<Number> numbers = Arrays.<Number>asList(3.2F, 0.2F);
        List<Integer> integerList = Arrays.asList(1, 2);
        Collections.copy(numbers, integerList);
    }

    static void printCollection(Collection<?> c){
        for(Object o : c){
            System.out.println(o);
        }
    }
}
