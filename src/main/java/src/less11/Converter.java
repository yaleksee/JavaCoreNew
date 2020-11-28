package src.less11;

@FunctionalInterface
public interface Converter<N, T> {
    N convert(T t);

    default boolean isNotNull(T t) {
        return t != null;
    }

    default void writeToConsole(T t) {
        System.out.println(t.toString());
    }

    boolean equals(Object obj);
}

class Dog {

    String name;
    int age;
    int weight;

    public Dog(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Cat {
    String name;
    int age;
    int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("B", 5, 3);

        Converter converter = x -> new Cat(dog.name, dog.age, dog.weight);

        Cat cat = (Cat) converter.convert(dog);

        System.out.println(cat);
    }
}
