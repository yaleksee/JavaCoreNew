package src.less11;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface CarFilter {

    boolean test(Car car);
}

class Car{

    public Car(int year, int power) {
        this.year = year;
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    private int year;

    public int getPower() {
        return power;
    }

    private int power;

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", power=" + power +
                '}';
    }

    public static void main(String[] args) {

        CarFilter carFilter = new CarFilter() {
            @Override
            public boolean test(Car car) {
                return false;
            }
        };
        CarFilter carFilter2 = car1 -> car1.getYear() >=2018;

        printCars(Arrays.asList(new Car(2010, 100), new Car(2010, 150), new Car(2010, 200), new Car(2010, 250)));
    }

    private static void printCars(List<Car> cars) {
        for(Car car : cars){
            if(car.getPower()>150){
                System.out.println(car.toString());
            }
        }
    }
}
