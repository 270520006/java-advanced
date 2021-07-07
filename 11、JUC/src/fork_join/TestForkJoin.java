package fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testFork();
        testStream();
    }
    public static void testFork() throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinTask = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinTask);
        Long forkDemo = submit.get();
        Long end = System.currentTimeMillis();
        System.out.println(forkDemo+"花费时间为"+((end-start)/1000L)+"s");
    }
    public static void testStream(){
        Long start = System.currentTimeMillis();
        Long sum= LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        Long end = System.currentTimeMillis();
        System.out.println(sum+"花费时间为"+((start-end)/1000L)+"s");
    }


}
