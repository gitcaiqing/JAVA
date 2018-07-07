package cq._08_Class.InnerClass;

public class TestInnerClass {
	
	public static void main(String[] args) {
		System.out.println("成员内部类------------------");
		//创建非静态的内部类的对象：必须先创建外部类的对象，
		//通过外部类的对象调用内部类的构造器
		Person p = new Person();
		Person.Bird b = p.new Bird();
		b.setName("杜鹃");
		b.info();
			
		//创建静态内部类的对象：可以直接通过外部类调用静态内部类的构造器
		System.out.println("静态内部类------------------");
		Person.Dog d = new Person.Dog();
		d.setName("dog");
		
		//局部内部类 在类的方法里面声明一个类
		System.out.println("局部内部类------------------");
		p.method();
		
		
	}
	
}


class Person{
	String name = "两个";
	int age;
	public boolean say(){
		return true;
	}
	public void show(){
		System.out.println("我是show()方法");
	}
	
	/**1.成员内部类
	 * 是外部类的一个成员属性 可以有修饰符 static/final
	 * 可以调用外部类的属性和方法
	 * 具体类的特点abstract, 还可以在内部定义属性方法构造器
	 * 
	 * */
	
	//1.1：非静态成员内部类
	class Bird{
		String name = "黄鹂";
		int id;
		public Bird(){
			
		}
		public void setName(String name){
			System.out.println(name);//杜鹃 
			System.out.println(this.name);//黄鹂 this是本类Bird
			System.out.println(Person.this.name);//两个 Person.this 调用外部类的属性
			Person.this.say();
		}
		public void info(){
			show();
		}
	}
	//1.2：静态成员内部类
	static class Dog{
		String name = "static dog";
		
		public void setName(String name){
			System.out.println(name);//杜鹃 
			System.out.println(this.name);//黄鹂 this是本类Bird
			
			//两个 Person.this 无法 调用外部类的属性和方法
			// 错误： System.out.println(Person.this.name);
		}
	}

	
	
	/**
	 * 局部内部类(声明在类的方法里)
	 */
	public void method(){
		
		String name = "method";
		
		class jubuClass{
			
			String name = "Jubu";
			
			public void setName(String name){
				System.out.println(name);//局部内部类setname"
				System.out.println(this.name);//Jubu
				System.out.println(Person.this.name);//两个
			}
			
		}
		
		new jubuClass().setName("局部内部类setname");
		
	}
}







