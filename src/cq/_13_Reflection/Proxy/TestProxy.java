package cq._13_Reflection.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 *接口 
 */
interface Subject{
	void action();
}

/**
 * 被代理类
 * @author Administrator
 */
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("我是被代理类！！！");
	}
}

/**
 * 动态代理类
 * 实现InvocationHandler接口
 * 实现invoke方法
 * @author Administrator
 *
 */
class MyInvocationHandler implements InvocationHandler{
	//1.实现了接口的被代理类的对象的声明
	Object obj;
	
	public Object blind(Object obj){
		this.obj = obj;
		//对象类加载器，实现的接口，代理类
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
 * 动态代理（根据反射）
 * @author Administrator
 *
 */
public class TestProxy {
	public static void main(String[] args) {
		//1.被代理类的对象
		RealSubject real = new RealSubject();
		//2.创建代理类对象
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
		//3.调用blind方法，动态返回一个同样实现了real所在类实现的接口Subject的代理类对象
		Object obj = myInvocationHandler.blind(real);
		Subject subject = (Subject) obj;System.out.println(subject);
		subject.action();//转到对invoke的调用
	}
}



















