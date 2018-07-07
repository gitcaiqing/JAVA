package cq._11_Thread_Create;

import java.util.ArrayList;


/**@Projectname: JAVA
 * @Typename: ThreadPoolManage 
 * @Description: TODO
 * @CreateDate:  2017-8-1 ����11:15:30
 * @LastModified: 2017-8-1 ����11:15:30
 * @Author: CQ 
 * @UpdateAuthor: CQ
 * @version: 1.0
 */

public class ThreadPoolManage {

	private int threadCount;
	
	private WorkThread[] handlers;
	
	//�������
	private ArrayList<Runnable> taskVectoRunnables = new ArrayList<Runnable>();
	
	void shundown(){
		synchronized (taskVectoRunnables) {
			while (!taskVectoRunnables.isEmpty()) {
				taskVectoRunnables.remove(0);
			}
		    for (int i = 0; i < threadCount; i++) {
	           handlers[i] = new WorkThread();
	           handlers[i].interrupt(); //�����߳�
		    }
		}
	}

    void execute(Runnable newTask) { //����������
       synchronized (taskVectoRunnables) {
    	   taskVectoRunnables.add(newTask);
    	   taskVectoRunnables.notifyAll();
       }
    }
	
	
	private class WorkThread extends Thread{
	
		public void run() {
			Runnable task = null;
			for(;;){
				synchronized (taskVectoRunnables) {//��ȡһ��������
				     if (taskVectoRunnables.isEmpty())
					     try {
					    	 taskVectoRunnables.wait();
					         task = taskVectoRunnables.remove(0);
					     } catch (InterruptedException e) {
					         break;
					     }
				}
				task.run();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadPoolManage threadPoolManage = new ThreadPoolManage();
		WorkThread workThread = threadPoolManage.new WorkThread();
		workThread.start();
	}
}




