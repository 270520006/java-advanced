package fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * 手写一个累加任务，要求传入数字大于10000的就拆分，
 * 拆分到1万为止开始相加，最后返回结果
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start; //初始值
    private Long end;//末尾值
    private final static Long TEMP=100000L;//临界值
    public ForkJoinDemo(Long start, Long end) {
        //构造参数，只有传入才能调用
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end-start<TEMP)
        {   Long sum =0L;
            for (Long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }else
        {
            Long mid =(end+start)/2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            ForkJoinDemo task2 = new ForkJoinDemo(mid+1, end);
            invokeAll(task1,task2);
            return task1.join()+task2.join();
        }
    }
}
