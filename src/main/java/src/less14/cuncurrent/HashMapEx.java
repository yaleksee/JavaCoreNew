package src.less14.cuncurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapEx {
    static Map<String, String> map;

    public static void concurrentHashMapExample() {
        System.out.println("ConcurrentHM");
        createMap(true);
        addValue(true);

        System.out.println("HM");
        createMap(false);
        addValue(false);
    }

    private static void addValue(boolean b) {
        System.out.println("before iterator: " + map);

        Iterator<String> t = map.keySet().iterator();

        while (t.hasNext()) {
            String key = t.next();
            if (key.equals("2")) {
                map.put(key + "new", "!!!!");
            } else {
                System.out.print(" " + key + " = " + map.get(key));
            }
        }
        System.out.println();
        System.out.println("after iterator: " + map);
    }

    private static void createMap(boolean concurrent) {
        if (concurrent) {
            map = new ConcurrentHashMap<String, String>();
        } else {
            map = new HashMap<String, String>();
        }

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        concurrentHashMapExample();
        System.exit(0);
    }
}
