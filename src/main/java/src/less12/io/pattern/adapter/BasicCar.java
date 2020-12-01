package src.less12.io.pattern.adapter;

/**
 *  Паттерн Адаптер – структурный шаблон проектирования,
 *  предназначенный для организации использования функций объекта, недоступного для модификации,
 *  через специально созданный интерфейс.
 *
 *  Паттерн адаптер предусматривает создание класса-оболочки с требуемым интерфейсом.
 */

public interface BasicCar{
    void drive();
    void xenonOn();
    void xenonOff();
}

interface BasicCarRus{
    void drive();
    void basicLightOn();
    void basicLightOff();
}

class AudiA3 implements BasicCar{
    final public int light = 100;

    @Override
    public void drive(){
        System.out.println("AudiA3 rides!");
    }

    @Override
    public void xenonOn(){
        System.out.println("AudiA3 xenon on ");
    }

    @Override
    public void xenonOff(){
        System.out.println("AudiA3 xenon off");
    }
}

class AudiA3Rus implements BasicCarRus{
    final public int light = 50;

    @Override
    public void drive(){
        System.out.println("AudiA3Rus поехал!");
    }

    @Override
    public void basicLightOn(){
        System.out.println("AudiA3Rus включили свет");
    }

    @Override
    public void basicLightOff(){
        System.out.println("AudiA3Rus выключили свет");
    }
}

class CarAdapter implements BasicCar{
    BasicCarRus basicCarRus;

    public CarAdapter(BasicCarRus basicCarRus){
        this.basicCarRus = basicCarRus;
    }

    @Override
    public void drive(){
        basicCarRus.drive();
    }

    @Override
    public void xenonOn(){
        basicCarRus.basicLightOn();
    }

    @Override
    public void xenonOff(){
        basicCarRus.basicLightOff();
    }
}

class CentralProcessor{
    private BasicCar car;
    public CentralProcessor(BasicCar car){
        this.car = car;
    }

    public void work(){
        car.drive();
        car.xenonOn();
        car.xenonOff();
    }
}

class Example{
    public static void main(String[] args){
        //создаем объект машины
        BasicCar audiA3 = new AudiA3();
        //создаем объект процессора и передаем ему в управления объект машины
        CentralProcessor cp = new CentralProcessor(audiA3);
        //процессор управляет работой машины
        cp.work();

        //создаем адаптер и передаем в него машину
        CarAdapter audiA3Rus = new CarAdapter(new AudiA3Rus());
        //создаем процессор и передаем в него адаптер
        CentralProcessor cpRus = new CentralProcessor(audiA3Rus);
        //процессор управляет машиной
        cpRus.work();
    }
}
