package cq._08_Class.InnerClass;

/**
 * �����ڲ���
 * @author Administrator
 *
 */
public class TestNoNameInnerClass {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.function(null);
		System.out.println("-------------");
		outer.function("aaaaaa");
	}
}

/**
 * �����ڲ���
 */
class niming{
}
/**
 * �ⲿ��
 * @author Administrator
 *
 */
class Outer{
	
	public void function(final String name){
		new niming(){
			String _name = "��ʼname";
			{
				if(name != null) {
					_name = name;
				}
			}
			private void say() {
				System.out.println(_name);
			}
		}.say();
		
		/*class innerclass{
			void innersy() {
				System.out.println(name);
			}
		};
		new innerclass().innersy();*/
		
	}
}






















