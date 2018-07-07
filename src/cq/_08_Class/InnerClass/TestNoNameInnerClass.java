package cq._08_Class.InnerClass;

/**
 * 匿名内部类
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
 * 匿名内部类
 */
class niming{
}
/**
 * 外部类
 * @author Administrator
 *
 */
class Outer{
	
	public void function(final String name){
		new niming(){
			String _name = "初始name";
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






















