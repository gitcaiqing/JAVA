package cq._11_Thread_Create;

public class TestRunnable implements Runnable{
	
	private String arg;
	
	public TestRunnable(String arg) {
		// TODO Auto-generated constructor stub
		this.arg = arg;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for(int i=20; i<30; i++){
			System.out.println(name+"的i___"+i+"_参数："+this.arg);
		}
	}
	
	public static void main(String[] args) {
		TestRunnable testRunnable1 = new TestRunnable("参数1");
		TestRunnable testRunnable2 = new TestRunnable("参数2");
		Thread r1 = new Thread(testRunnable1);
		Thread r2 = new Thread(testRunnable2);
		r1.setName("线程1");
		r2.setName("线程2");
		r1.start();
		//r2.start();
		r1.run();
		/*for(int i=0; i<10; i++){
			System.out.println("主线程的i__"+i);
			
		}*/
		
	}

	
}
