package cq._13_Reflection.Other;



import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestOther {
	@Test
	public void testOther(){
		
		Class clazz = Person.class;
		
		//1.获取注解
		Annotation[] annos = clazz.getAnnotations();
		for(Annotation anno:annos){
			System.out.println("注解："+anno);
		}
		
		//2.获取所在的包
		Package pack = clazz.getPackage();
		System.out.println("所在包："+pack);
		
		//3.获取实现的类
		Class[] interfaces = clazz.getInterfaces();
		for(Class inter:interfaces){
			System.out.println("实现的类："+inter);
		}
		//4.获取父类
		Class superClass = clazz.getSuperclass();
		System.out.println("父类："+superClass);
		
		//5.获取带泛型的父类
		Type type = clazz.getGenericSuperclass();
		System.out.println("带泛型父类："+type);
		//6.获取父类的泛型		
		Type superGener = clazz.getGenericSuperclass();
		
		ParameterizedType param = (ParameterizedType)superGener;
		Type[] ars = param.getActualTypeArguments();
		
		System.out.println("父类泛型："+((Class)ars[0]).getName());
		
		
		
		
	}
}
