package src.less9.ex7;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");
        strings.add("1");


//        for (String s : strings) {
//            strings.remove(2);
//        }

        String[] arrayStrings = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            arrayStrings[i] = strings.get(i);
        }

        List list = new ArrayList();
        for (String s : arrayStrings) {
            list.add(s);
        }

        Set set = new HashSet<String>(list);
        list.clear();
        list.addAll(set);
        System.out.println(list);
    }
}
