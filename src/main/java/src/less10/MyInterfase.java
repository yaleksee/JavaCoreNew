package src.less10;

public interface MyInterfase <T>{
    T someMethod(T t);
}

class MyClass<T> implements MyInterfase<T>{

    @Override
    public T someMethod(T t) {
        return t;
    }

    public static void main(String[] args) {
        MyInterfase<String> myInterfase = new MyClass<>();
        String s = myInterfase.someMethod("sdsadsasd");
        System.out.println(s);
    }
}
