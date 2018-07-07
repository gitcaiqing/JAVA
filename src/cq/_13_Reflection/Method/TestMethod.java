package cq._13_Reflection.Method;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestMethod {
	/**
	 * ��ȡ����ʱ��ķ������丸������Ϊpublic �ķ���
	 * ��ȡ����ʱ��ķ���
	 * @throws Exception
	 */
	@Test
	public void testMethod() throws Exception{
		Class<Person> clazz = Person.class;
		//1.getMethods():��ȡ����ʱ�༰�丸�������е�����Ϊpublic�ķ���
		Method[] methodNames = clazz.getMethods();
		for(Method mds:methodNames){
			System.out.println(mds.getName());
		}
		
		System.out.println("------------------------------");
		
		//2.getDeclaredMethods():��ȡ����ʱ�౾�����������еķ���
		Method[] safemethodNames = clazz.getDeclaredMethods();
		for(Method md:safemethodNames){
			System.out.println(md.getName());
		}
		
	
	}
	
	/**
	 * ��ȡָ�����͵�
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
		
		//private ���εķ������� setAccessible(true);��ſ��Է���
		md.setAccessible(true);
		Person p = clazz.newInstance();
		md.invoke(p, "reflection word");
	}
	/**
	 * ע��
	 * Ȩ�����η�
	 * ����ֵ����
	 * ������
	 * �����б�
	 * �쳣
	 */
	@Test
	public void testOtherArgs(){
		Class<?> clazz = Person.class;
		Method[] mds = clazz.getDeclaredMethods();
		for(Method md:mds){
			System.out.println("������================��"+md.getName());
			//1.ע��
			Annotation[] annotations = md.getAnnotations();
			for(Annotation anno:annotations){
				System.out.println("ע���ǣ�"+anno);
			}
			//2.Ȩ�����η�
			String moddifierStr = Modifier.toString(md.getModifiers());
			System.out.println("���η���"+moddifierStr);
			
			//3.����ֵ����
			Class<?> returnType = md.getReturnType();
			System.out.println("�������ͣ�"+returnType);
			
			//4.�����б�
			Class<?>[] paras = md.getParameterTypes();
			for(Class<?> para:paras){
				System.out.println("�����б�"+para.getName());
			}
		}
	}
}









