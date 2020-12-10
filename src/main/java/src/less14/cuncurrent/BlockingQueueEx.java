package src.less14.cuncurrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueEx {
    private BlockingQueue<String> drop;
    private final String DONE="done";
    private final String[] messages = {
            "Мама пошла готовить обед",
            "Мама позвола к столу",
            "Дети едят кашу",
            "А что ест папа?"
    };
    public BlockingQueueEx(){
        drop = new ArrayBlockingQueue<String>(1, true);
        (new Thread(new Producer())).start();
        (new Thread(new Producer2())).start();
        (new Thread(new Consumer())).start();
    }

    class Producer implements Runnable{
        @Override
        public void run() {
            int cnt = 0;
            try {
                for (int i = 0; i < messages.length; i++) {
                    drop.put("Producer1: " + messages[i]);
                    if (++cnt < 3) {
                        Thread.sleep(3000);
                    }
                }
                drop.put(DONE);
            } catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
    }

    class Producer2 implements Runnable{
        @Override
        public void run() {
            int cnt = 0;
            try {
                for (int i = 0; i < messages.length; i++) {
                    drop.put("Producer2: " + messages[i]);
                    if (++cnt < 3) {
                        Thread.sleep(2000);
                    }
                }
                drop.put(DONE);
            } catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            String msg = null;
            try {
                while (!((msg = drop.take()).equals(DONE))) {
                    System.out.println(msg);
                }
            }catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new BlockingQueueEx();
    }

}
