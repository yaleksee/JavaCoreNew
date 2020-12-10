package src.less14.cuncurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecServExample {
    public static void main(String[] args) {
        ExecutorService serv = Executors.newFixedThreadPool(5); // Создаем пул потоков
        for (int i = 0; i < 20; i++) { // Пытаемся одновременно запустить 20 потоков
            String w = "#" + i;
            serv.submit(() -> {  // вытаскиваем из пула неактивный поток и даем ему задачу,
                // если пул пуст, ждем пока появится свободный поток
                System.out.println(Thread.currentThread().getName() + " - " + w);
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
        }
        serv.shutdown(); // выключаем пул потоков
    }
}
