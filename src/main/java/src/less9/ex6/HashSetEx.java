package src.less9.ex6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("string1");
        stringHashSet.add("string2");
        stringHashSet.add("string3");
        stringHashSet.add("string4");
        stringHashSet.add("string2");
        System.out.println(stringHashSet);

        Random random = new Random(30);
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            integerSet.add(random.nextInt(10));
        }

        Iterator<Integer> integerIterator = integerSet.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next().toString());
        }

    }
}
