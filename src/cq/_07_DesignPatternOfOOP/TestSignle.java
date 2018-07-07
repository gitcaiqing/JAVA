package cq._07_DesignPatternOfOOP;
/**
 * 单例设计模式
 * @author Administrator
 * java有23种设计模式
 * 解决一个类在内存只存在一个对象，保证对象的唯一
 * 为了让其他程序可以访问到该类对象，可以对外提供一些访问方式
 * 1 将构造函数私有化
 * 2 在类中创建一个静态私有对象
 * 3 提供一个方法可以获取到该对象
 */
public class TestSignle {
	public static void main(String[] args) {
		//1.访问饿汉式创建的对象
		HungrySignle hungrySignle = HungrySignle.getInstance();
		System.out.println("hungrySignle:"+hungrySignle);
	
		//2.访问懒汉式创建对象
		LazySignle lazySignle = LazySignle.getInstance();
		System.out.println("lazySignle:"+lazySignle);
	
	}
}


/**
 * 1.饿汉式:先初始化对象
 * 建议使用该设计模式
 */
class HungrySignle{
	//1.private修饰后保证了其唯一性,但外部无法访问该对象
	private HungrySignle(){};
	//2.调用前初始化对象
	private static HungrySignle hungrySignle = new HungrySignle();
	//3.为了能够访问该对象，需要创建一个访问接口
	public static HungrySignle getInstance(){
		return hungrySignle;
	}
}

/**
 * 2.懒汉式 :加载时初始化对象
 * 对象在方法调用时才进行初始化
 * 多个程序初始化对象时，容易出现安全问题 所以需要同步synchronized
 * 效率低	
 */

class LazySignle{
	//1同上
	private LazySignle(){};
	//2.
	private static LazySignle lazySignle = null;
	//3.调用
	public static synchronized LazySignle getInstance(){
		//3.1.初始化
		if( lazySignle == null){
			synchronized (LazySignle.class) {
				if(lazySignle == null){
					lazySignle = new LazySignle();
				}
			}
		}
		return lazySignle;
	}
	
}
