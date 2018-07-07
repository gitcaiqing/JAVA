package cq._13_Reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 *�ӿ� 
 */
interface Subject{
	void action();
}

/**
 * ��������
 * @author Administrator
 */
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("���Ǳ������࣡����");
	}
}

/**
 * ��̬������
 * ʵ��InvocationHandler�ӿ�
 * ʵ��invoke����
 * @author Administrator
 *
 */
class MyInvocationHandler implements InvocationHandler{
	//1.ʵ���˽ӿڵı�������Ķ��������
	Object obj;
	
	public Object blind(Object obj){
		this.obj = obj;
		//�������������ʵ�ֵĽӿڣ�������
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
					obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}
}

/**
 * ��̬�������ݷ��䣩
 * @author Administrator
 *
 */
public class TestProxy {
	public static void main(String[] args) {
		//1.��������Ķ���
		RealSubject real = new RealSubject();
		//2.�������������
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		//3.����blind��������̬����һ��ͬ��ʵ����real������ʵ�ֵĽӿ�Subject�Ĵ��������
		Object obj = myInvocationHandler.blind(real);
		Subject subject = (Subject) obj;System.out.println(subject);
		subject.action();//ת����invoke�ĵ���
	}
}



















