package src.less14.synch;

public class ATM {
    private int money;

    public ATM(int money) {
        this.money = money;
    }

    public void getMoney(User user, int amount) {
        if(money >= amount) {
            // Время на проверку денег
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("to " + user.getName() + ": " + amount);
        } else {
            System.out.println("to " + user.getName() + ": we need more gold...");
        }
    }

    public synchronized void getSynchMoney(User user, int amount) {
        if(money >= amount) {
            // Время на проверку денег
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            money -= amount;
            System.out.println("to " + user.getName() + ": " + amount);
        } else {
            System.out.println("to " + user.getName() + ": we need more gold...");
        }
    }

    public void info() {
        System.out.println("ATM: " + money);
    }

    public void reset(int money) {
        this.money = money;
    }
}
