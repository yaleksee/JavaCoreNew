package src.less9.ex4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        Map<Integer, String> passportAndNames = new HashMap<>();
        Map<Integer, String> passportAndNames2 = new HashMap<>();
        passportAndNames.put(23213, "FIO1");
        passportAndNames.put(34324234, "FIO2");
        passportAndNames.put(213213213, "FIO3");
        passportAndNames.put(546546, "FIO4");
        passportAndNames.put(546546, "FIO5");

        passportAndNames2.put(11, "FIO1");
        passportAndNames2.put(22, "FIO2");
        passportAndNames2.put(33, "FIO3");
        passportAndNames2.put(44, "FIO4");
        passportAndNames2.put(55, "FIO5");

        String name = passportAndNames.get(213213213);
        System.out.println(name);

        passportAndNames.remove(213213213);

        System.out.println(passportAndNames.containsKey(213213213));
        System.out.println(passportAndNames.containsValue("FIO5"));

        passportAndNames.putAll(passportAndNames2);

        Set<Integer> integers = passportAndNames.keySet();
        ArrayList<String> stringArrayList = new ArrayList<>(passportAndNames.values());

        System.out.println(passportAndNames.isEmpty());

        for (Map.Entry entry : passportAndNames.entrySet()) {
            System.out.println(entry);
        }

        System.out.println(passportAndNames);
    }
}
