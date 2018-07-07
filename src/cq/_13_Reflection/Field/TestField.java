package cq._13_Reflection.Field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestField {
	/**
	 * 获取属性
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * 
	 */
	@Test
	public void testField() throws Exception{
		Class<Person> clazz = Person.class;
		
		//1.getFields()
		//获取运行时类 及其父类的public属性
		Field[] fields = clazz.getFields();
		for(int i=0; i<fields.length; i++){
			System.out.println("本类及其父类的属性："+fields[i]);
		}
		System.out.println("-------------------------");
		
		//2.获取该类本身的属性
		Field[] fieldSelf = clazz.getDeclaredFields();
		for(Field f:fieldSelf){
			System.out.println("本类的属性："+f);
			System.out.println("属性的名字："+f.getName());
			//3获取每个属性的权限修饰符
			int mod = f.getModifiers();
			String mdfStr = Modifier.toString(mod);
			System.out.println("权限修饰符："+mdfStr);
			//4.获取属性的类型
			Class type = f.getType();
			System.out.println("属性的类型："+type.getName());
			System.out.println("");
		}
		
		
		
		//5获取本类的特定属性
		//getField(String fieldName):获取运行时类中声明为public的指定属性名为fieldName的属性
		Field age = clazz.getField("age");
		System.out.println("-------------------");
		System.out.println(age);
		
		//由于属性权限修饰符的限制，为了保证可以给属性赋值，
		//需要在操作前使得此属性可被操作。
		age.setAccessible(true);
		
		//6运行时赋值
		Person p = clazz.newInstance();
		System.out.println("p:"+p);
		//
		
		age.set(p, 16);
		System.out.println("p2:"+p);
		System.out.println(age.get(p));
		
	}
	
}
