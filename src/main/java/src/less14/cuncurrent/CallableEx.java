package src.less14.cuncurrent;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Stream;

public class CallableEx {

    static BigDecimal bigDecimal = null;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable task = () -> {
            //
            return new BigDecimal(5);
        };

        FutureTask<BigDecimal> futureTask = new FutureTask<>(task);

        new Thread(futureTask).start();

        while (futureTask.isDone()) {
            bigDecimal = futureTask.get();
            System.out.println(bigDecimal);
        }

    }
}


class App {
    public static void main(String[] args) {
        CompletableFuture<String> completed;
        completed = CompletableFuture.completedFuture("Simple string");

        CompletableFuture<Void> voidCompletableFuture;
        voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("run: " + Thread.currentThread().getName());
        });

        CompletableFuture<String> ended;
        ended = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply: " + Thread.currentThread().getName());
            return "Point";
        });

        List<String> array = Arrays.asList("one", "two");
        Stream<String> stringStream = array.stream().map(value -> {
            System.out.println("Execute");
            return value.toUpperCase();
        });
        System.out.println(array);

    }
}
