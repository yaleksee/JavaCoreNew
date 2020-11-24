package src.less10;

import java.io.Serializable;

public class Average<T extends Number> {
    private T[] array;

    public Average(T[] array) {
        this.array = array;
    }

    public double average() {
        double sum = 0;
        for (T value : array) {
            sum += ((Number)value).doubleValue();
        }
        return sum / array.length;
    }


    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Average<Integer> integerAverage = new Average<>(integers);
        System.out.println(integerAverage.average());

        Double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0};
        Average<Double> doubleAverage = new Average<>(doubles);
        System.out.println(doubleAverage.average());

//        String[] strings = {"dsf", "dsf", "sdf", "sdf", "dsf"};
//        Average<String> stringAverage = new Average<>(strings);
//        System.out.println(doubleAverage.average());
    }
}
