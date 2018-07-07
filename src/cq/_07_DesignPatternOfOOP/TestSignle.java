package cq._07_DesignPatternOfOOP;
/**
 * �������ģʽ
 * @author Administrator
 * java��23�����ģʽ
 * ���һ�������ڴ�ֻ����һ�����󣬱�֤�����Ψһ
 * Ϊ��������������Է��ʵ�������󣬿��Զ����ṩһЩ���ʷ�ʽ
 * 1 �����캯��˽�л�
 * 2 �����д���һ����̬˽�ж���
 * 3 �ṩһ���������Ի�ȡ���ö���
 */
public class TestSignle {
	public static void main(String[] args) {
		//1.���ʶ���ʽ�����Ķ���
		HungrySignle hungrySignle = HungrySignle.getInstance();
		System.out.println("hungrySignle:"+hungrySignle);
	
		//2.��������ʽ��������
		LazySignle lazySignle = LazySignle.getInstance();
		System.out.println("lazySignle:"+lazySignle);
	
	}
}


/**
 * 1.����ʽ:�ȳ�ʼ������
 * ����ʹ�ø����ģʽ
 */
class HungrySignle{
	//1.private���κ�֤����Ψһ��,���ⲿ�޷����ʸö���
	private HungrySignle(){};
	//2.����ǰ��ʼ������
	private static HungrySignle hungrySignle = new HungrySignle();
	//3.Ϊ���ܹ����ʸö�����Ҫ����һ�����ʽӿ�
	public static HungrySignle getInstance(){
		return hungrySignle;
	}
}

/**
 * 2.����ʽ :����ʱ��ʼ������
 * �����ڷ�������ʱ�Ž��г�ʼ��
 * ��������ʼ������ʱ�����׳��ְ�ȫ���� ������Ҫͬ��synchronized
 * Ч�ʵ�	
 */

class LazySignle{
	//1ͬ��
	private LazySignle(){};
	//2.
	private static LazySignle lazySignle = null;
	//3.����
	public static synchronized LazySignle getInstance(){
		//3.1.��ʼ��
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
