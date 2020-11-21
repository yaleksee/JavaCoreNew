package src.less9.ex3;

import java.util.Objects;

public class Box {
    private int a;
    private int b;

    public Box(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // x = y ; y = x

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return a == box.a &&
                b == box.b;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(a, b);
//    }

    public static void main(String[] args) {
        Box box = new Box(1,2);
        Box box2 = new Box(1,2);

        System.out.println(box.hashCode());
        System.out.println(box.hashCode());
        System.out.println(box2.hashCode());

        System.out.println(box.equals(box2));

        box = null;

        //System.out.println(box.hashCode());


    }
}
