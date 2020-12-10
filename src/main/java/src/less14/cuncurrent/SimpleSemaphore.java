package src.less14.cuncurrent;

import java.util.concurrent.Semaphore;

//Mutual exclusion
public class SimpleSemaphore {
    public static void main(String[] args) {
        final Semaphore smp = new Semaphore(4);
        Runnable limitedCall = new Runnable() {
                    int count = 0;
                    public void run() {
                        int time = 3 + (int) (Math.random() * 4.0);
                        int num = count++;
                        try {
                            smp.acquire(); // в этой секции поток захватывает семафор,
                            // если в нем есть свободные места, если мест нет,
                            // ждет пока не появится место
                            System.out.println("Поток #" + num + " начинает выполнять очень долгое действие "
                                    + time + " сек.");
                            Thread.sleep(time * 10); // делаем вид, что поток выполняет важную задачу
                            System.out.println("Поток #" + num + " завершил работу!");
                            smp.release(); // освобождаем семафор, чтобы другой поток мог его занять
                        } catch (InterruptedException intEx) {
                            intEx.printStackTrace();
                        }
                    }
                };
        for (int i = 0; i < 10; i++)
            new Thread(limitedCall).start(); // пытаемся запустить одновременно 10 потоков
    }
}
