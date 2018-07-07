package cq._11_Thread_Create;

/**
 * �̳�Thread��
 * @author Administrator
 *
 */
public class TestThread extends Thread{
	
	public void run(){
		String name = this.getName();
		for(int i=20; i<30; i++){
			System.out.println(name+"��__i="+i);
		}
	}
	//���߳�
	public static void main(String[] args) {
		
		TestThread testThread1 = new TestThread();
		testThread1.setName("�߳�1");
		TestThread testThread2 = new TestThread();
		testThread2.setName("�߳�2");
		//�����߳� ִ��run����
		testThread1.start();
		testThread2.start();
		for(int i=0; i<10; i++){
			System.out.println("���ߵ�___i:"+i);
		}
	}
}


/**
 * ʵ��Runnable�ӿ�
 * @author Administrator
 *
 */
class TestRuanalbe implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
