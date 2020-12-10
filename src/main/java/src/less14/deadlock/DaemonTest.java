package src.less14.deadlock;

public class DaemonTest {

    public static void main(String[] args) {
        new WorkerThread().start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        System.out.println("Main Thread ending") ;
    }

}

class WorkerThread extends Thread {

    public WorkerThread() {

        setDaemon(true);
    }

    @Override
    public void run() {
        int count = 0;

        while (true) {
            System.out.println("Hello from DEMON "+count++);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
