package src.less14.cuncurrent;

import java.util.concurrent.CountDownLatch;

public class SimpleCDL {
    public static void main(String[] args) {
        final int THREADS_COUNT = 4; // задаем кол-во потоков
        final CountDownLatch cdl = new CountDownLatch(THREADS_COUNT); // задаем значение счетчика
        System.out.println("START");
        for (int i = 0; i < 10; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    Thread.sleep(200 * w + (int)(1500 * Math.random())); // считаем что выполнение задачи занимает 2 сек
                    cdl.countDown(); // как только задача выполнена, уменьшаем счетчик
                    System.out.println("THREAD #" + w + " - Ready");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await(); // ждем пока счетчик не сбросится в ноль, пока это не произойдет, будем стоять на этой строке
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВЫПОЛНЯЕТСЯ только для потоков в CountDownLatch"); // как только все потоки выполнили свои задачи - пишем сообщение
    }
}
