package src.less9.ex5;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//@Fork(value = 3, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 0)
@Fork(value = 1, warmups = 0)
@Warmup(iterations = 5, time = 1_500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1_500, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(value = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class PerformanceTestArrayListAndLinkedList {
    private static List<Object> arrayList;
    private static List<Object> linkedList;

    private static final int count = 10000;

    public static void main(String[] args) throws Exception {
        Main.main(args);
    }

    @Setup
    public static void setup() {
        arrayList = new ArrayList<>(count);
        linkedList = new LinkedList<>();

        for (int i = 0; i < count; i++)
            arrayList.add(new Object());

        linkedList.addAll(arrayList);
    }

    @Benchmark
    public void removeFromLinkedList(Blackhole blackhole) throws Exception {
        Object object = new Object();
        linkedList.remove(count / 2);
        linkedList.add(count / 2, object);
    }

    @Benchmark
    public void removeFromArrayList(Blackhole blackhole) throws Exception {
        Object object = new Object();
        arrayList.remove(count / 2);
        arrayList.add(count / 2, object);
    }
}
