package cq._11_Thread_Create;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestFutureTask {

    public static void main(String[] args) {
        TestFutureTask testFutureTask = new TestFutureTask();

        FutureTask<Integer> futureTask = new FutureTask<Integer>((Callable<Integer>) () ->{
            int i = 0;
            for (; i<100; i++){
                System.out.println(Thread.currentThread().getName()+"变量i1="+i);
            }
            return i;
        });

        for(int i=0 ; i<100; i++){
            System.out.println(Thread.currentThread().getName()+"变量i2="+i);
            if(i == 20){
                new Thread(futureTask, "有返回值线程").start();
            }
        }
        try {
            System.out.println("返回值" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
