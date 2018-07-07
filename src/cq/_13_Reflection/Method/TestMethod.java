package cq._13_Reflection.Method;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestMethod {
	/**
	 * 获取运行时类的方法及其父类声明为public 的方法
	 * 获取运行时类的方法
	 * @throws Exception
	 */
	@Test
	public void testMethod() throws Exception{
		Class<Person> clazz = Person.class;
		//1.getMethods():获取运行时类及其父类中所有的声明为public的方法
		Method[] methodNames = clazz.getMethods();
		for(Method mds:methodNames){
			System.out.println(mds.getName());
		}
		
		System.out.println("------------------------------");
		
		//2.getDeclaredMethods():获取运行时类本身声明的所有的方法
		Method[] safemethodNames = clazz.getDeclaredMethods();
		for(Method md:safemethodNames){
			System.out.println(md.getName());
		}
		
	
	}
	
	/**
	 * 获取指定类型的
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@Test
	public void testOneMethod() throws Exception{
		Class<Person> clazz = Person.class;
		Method md = clazz.getDeclaredMethod("hello",String.class);
		System.out.println(md.getName());
		
		//private 修饰的方法调用 setAccessible(true);后才可以访问
		md.setAccessible(true);
		Person p = clazz.newInstance();
		md.invoke(p, "reflection word");
	}
	/**
	 * 注解
	 * 权限修饰符
	 * 返回值类型
	 * 方法名
	 * 参数列表
	 * 异常
	 */
	@Test
	public void testOtherArgs(){
		Class<?> clazz = Person.class;
		Method[] mds = clazz.getDeclaredMethods();
		for(Method md:mds){
			System.out.println("方法名================："+md.getName());
			//1.注解
			Annotation[] annotations = md.getAnnotations();
			for(Annotation anno:annotations){
				System.out.println("注解是："+anno);
			}
			//2.权限修饰符
			String moddifierStr = Modifier.toString(md.getModifiers());
			System.out.println("修饰符："+moddifierStr);
			
			//3.返回值类型
			Class<?> returnType = md.getReturnType();
			System.out.println("返回类型："+returnType);
			
			//4.参数列表
			Class<?>[] paras = md.getParameterTypes();
			for(Class<?> para:paras){
				System.out.println("参数列表："+para.getName());
			}
		}
	}
}









