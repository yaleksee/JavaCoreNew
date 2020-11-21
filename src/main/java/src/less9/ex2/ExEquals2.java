package src.less9.ex2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ExEquals2 {
    public static void main(String[] args) {
        getTimeoiWorkList(new ArrayList());
        getTimeoiWorkList(new LinkedList());
    }

    private static void getTimeoiWorkList(List list) {
        Date currentTime = new Date();
        insert1Mil(list);

        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime();
        System.out.println(msDelay);
    }

    private static void insert1Mil(List list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add(0, new Object());
        }
    }

}
