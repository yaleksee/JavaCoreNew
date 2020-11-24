package src.less10;

import java.util.List;

public class Test {
    public long getSum(List<Account> accounts) {
        long sum = 0;

        for (Object account : accounts) {
            sum += ((Account) account).getSumm();
        }
        return sum;
    }
}


class Account {
    private long summ = 100;

    public long getSumm() {
        return summ;
    }

    public Account(long summ) {
        this.summ = summ;
    }
}
