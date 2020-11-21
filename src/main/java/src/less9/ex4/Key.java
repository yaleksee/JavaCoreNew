package src.less9.ex4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Key {
    String key;

    public Key(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key1 = (Key) o;
        return Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(new Key("Key1"), 20); // 75
        map.put(new Key("Key2"), 30); // 75

        int i = (int) map.get(new Key("Key2")); // 0(1)

        System.out.println(map);
    }
}
