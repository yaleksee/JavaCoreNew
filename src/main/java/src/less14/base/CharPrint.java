package src.less14.base;

public class CharPrint {
    private final Object monitor = new Object();
    private volatile char currentChar = 'A';

    public void printA (){
        new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (currentChar != 'A') monitor.wait();
                        System.out.print(currentChar);
                        currentChar = 'B';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void printB (){
        new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (currentChar != 'B') monitor.wait();
                        System.out.print(currentChar);
                        currentChar = 'C';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void printC (){
        new Thread(() -> {
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (currentChar != 'C') monitor.wait();
                        System.out.print(currentChar);
                        currentChar = 'A';
                        monitor.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        CharPrint cp = new CharPrint();
        cp.printA();
        cp.printB();
        cp.printC();
    }
}


