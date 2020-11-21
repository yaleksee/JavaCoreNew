package src.less9.ex2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExEquals {
    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>(); // 3831
        List<Integer> integerList2 = new ArrayList<>(); // 1371

        for (int i = 0; i < 5_000_000; i++) {
            integerList2.add(new Integer(i));
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            integerList2.add(2_000_000, new Integer(Integer.MAX_VALUE));
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
