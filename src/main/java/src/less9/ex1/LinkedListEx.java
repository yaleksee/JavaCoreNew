package src.less9.ex1;

import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        String str1 = new String("String1");
        String str2 = new String("String2");
        String str3 = new String("String3");
        String str4 = new String("String4");
        String str5 = new String("String5");

        LinkedList<String> strings = new LinkedList<>();
        strings.add(str1);
        strings.add(str2);
        strings.add(str3);
        strings.add(str4);
        strings.add(str5);

        strings.add(1, str2);
        strings.remove(1);

        strings.addFirst("1");
        strings.addLast("6");

        System.out.println(strings);
    }
}
