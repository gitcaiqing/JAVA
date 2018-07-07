package cq._13_Reflection.Constructor;

import java.lang.reflect.Constructor;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestConstructor {
	
	/**
	 * 通过反射获取运行时类的构造器
	 *Exception 
	 */
	@Test
	public void testConstructor() throws Exception{
		Class<Person> clazz = Person.class;
		//1.调用无参构造器
		//创建对应的运行时类的对象。使用newInstance()，
		//实际上就是调用了运行时类的空参的构造器。
		//要想能够创建成功：
		//①要求对应的运行时类要有空参的构造器。
		//②构造器的权限修饰符的权限要足够。
		Person p = clazz.newInstance();
		System.out.println(p);
		System.out.println("-----------------------");
		//2.调用声明了的构造器
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for(Constructor con:constructors){
			System.out.println(con);
		}
		
		System.out.println("-----------------------");
		
		//3.获取指定构造器
		Constructor constructor = clazz.getDeclaredConstructor(String.class);
		System.out.println(constructor);
	}
	
	
	
}
