package src.less14.cuncurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {

    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }


}

class Store {
    private int products = 0;
    ReentrantLock locker;
    Condition condition;

    public Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void get() {
        locker.lock();
        try {
            while (products < 1)
                condition.await();

            products--;
            System.out.println("Покупатель купил 1 продукт");
            System.out.println("Осталось товаров: " + products);

            condition.signalAll();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void put() {
        locker.lock();
        try {
            while (products >= 3)
                condition.await();

            products++;
            System.out.println("Производитель привез 1 продукт");
            System.out.println("Осталось на ветрине: " + products);

            condition.signalAll();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}

class Producer implements Runnable{
    public Producer(Store store) {
        this.store = store;
    }

    Store store;

    @Override
    public void run() {
        for(int i  = 1; i<6; i++){
            store.put();
        }
    }
}

class Consumer implements Runnable{
    public Consumer(Store store) {
        this.store = store;
    }

    Store store;

    @Override
    public void run() {
        for(int i  = 1; i<6; i++){
            store.get();
        }
    }
}
