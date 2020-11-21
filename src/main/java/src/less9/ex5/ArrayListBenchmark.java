package src.less9.ex5;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Fork(value = 3, jvmArgs = {"-Xms2G", "-Xmx2G"}, warmups = 0)
@Warmup(iterations = 5, time = 1_500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1_500, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(value = TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class ArrayListBenchmark {

    public static void main(String[]args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(ArrayListBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class MyState {

        List<Employee> employeeList = new ArrayList<Employee>();
//        List<Employee> employeeList = new LinkedList<>();
//        Set<Employee> employeeList = new HashSet<Employee>();

        long iterations = 10000;

        Employee employee = new Employee(100L, "Harry");

        int employeeIndex = -1;

        @Setup(Level.Trial)
        public void setUp() {
            for (long i = 0; i < iterations; i++) {
                employeeList.add(new Employee(i, "John"));
            }

            employeeList.add(employee);
            employeeIndex = employeeList.indexOf(employee);
        }
    }

    @Benchmark
    public void testAdd(MyState state) {
        state.employeeList.add(new Employee(state.iterations + 1, "John"));
    }

    @Benchmark
    public void testAddAt(MyState state) {
        state.employeeList.add((int) (state.iterations), new Employee(state.iterations, "John"));
    }

    @Benchmark
    public boolean testContains(MyState state) {
        return state.employeeList.contains(state.employee);
    }

    @Benchmark
    public int testIndexOf(MyState state) {
        return state.employeeList.indexOf(state.employee);
    }

    @Benchmark
    public Employee testGet(MyState state) {
        return state.employeeList.get(state.employeeIndex);
    }

    @Benchmark
    public boolean testRemove(MyState state) {
        return state.employeeList.remove(state.employee);
    }

}


