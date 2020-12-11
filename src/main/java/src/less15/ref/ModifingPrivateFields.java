package src.less15.ref;

import java.lang.reflect.Field;

public class ModifingPrivateFields {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        System.out.println(myClass);

        Field f = myClass.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(myClass, 100);
        System.out.println(myClass);

        Field f2 = myClass.getClass().getDeclaredField("s");
        f2.setAccessible(true);
        f2.set(myClass, "MODIFY S");
        System.out.println(myClass);

        Field f3 = myClass.getClass().getDeclaredField("s2");
        f3.setAccessible(true);
        f3.set(myClass, "MODIFY S2");
        System.out.println(myClass);


        MyClass myClass2 = null;

        Class clazz = Class.forName(MyClass.class.getName());
        myClass2 = (MyClass) clazz.newInstance();
        System.out.println(myClass2);
    }
}

class MyClass{
    private int i = 1;
    private final String s = "FINAL STRING";
    private String s2 = "STRING";

    @Override
    public String toString() {
        return "MyClass{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", s2='" + s2 + '\'' +
                '}';
    }
}
