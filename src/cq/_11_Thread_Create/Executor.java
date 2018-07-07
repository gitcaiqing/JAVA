package cq._11_Thread_Create;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * ʹ��ExecutorService��Callable��Futureʵ���з��ؽ���Ķ��߳�
 */
public class Executor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("--����ʼִ��");
		Date date = new Date();
		
		int taskSize = 5;
		//�̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		
		List<Future> list = new ArrayList<Future>();
		for(int i = 0; i < taskSize; i++) {
			Callable callable = new MyCallable(i+"");
			Future future = pool.submit(callable);
			list.add(future);
		}
		pool.shutdown();
		for(Future f:list) {
			System.out.println(f.get().toString());
		}
	}
	
	
}

class MyCallable implements Callable<Object> {  
	private String tasknum;  
	 
	MyCallable(String tasknum) {  
	   this.tasknum = tasknum;  
	}  
	
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("����"+tasknum+"����");
		Date date = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime()-date.getTime();
		System.out.println("����"+tasknum+"����");
		return tasknum+"��������ʱ"+time;
	}
	
}
