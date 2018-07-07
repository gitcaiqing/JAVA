package cq._13_Reflection.TestReflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class Reflection {
	@Test
	public void testReflection() throws Exception{
		//1.反射的源头  运行时类 Person
		Class<Person> clazz = Person.class;
		
		//2.创建clazz对应得运行时类Person
		Person p = (Person) clazz.newInstance();
		System.out.println(p);
		
		//3.通过反射调用运行时类的属性
		Field f1 = clazz.getField("name");
		f1.set(p, "caiqing");
		System.out.println(p);
		Field f2 = clazz.getField("age");
		f2.set(p, 20);
		System.out.println(p);
		
		//4.通过反射调用运行时方法
		Method m1 = clazz.getMethod("say");
		m1.invoke(p);
		
	}
	@Test
	public void testGetClazz() throws ClassNotFoundException, IOException{
		//1.调用运行时类的本身的.class
		Class<Person> clazz = Person.class;
		System.out.println(clazz.getName());
		
		//2.通过运行时类的对象获取
		Person p = new Person();
		System.out.println(p.getClass().getName());
		
		//3.通过Class的静态方法forName获取
		String className = "cq._13_Reflection.TestReflection.Person";
		Class clazz3 = Class.forName(className);
		System.out.println(clazz3.getName());
		
		//4.通过类的加载器classLoader
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream("cq/_13_Reflection/TestReflection/db.properties");
		
		//4.*通过文件的方式也可以
		//FileInputStream is = new FileInputStream(new File("db.properties"));
		
		System.out.println(is);
		Properties pros = new Properties();
		pros.load(is);
		String name = pros.getProperty("jdbc.user");
		System.out.println("name:"+name);
		String password = pros.getProperty("jdbc.password");
		System.out.println("pasword:"+password);
		
		
	}
}





























