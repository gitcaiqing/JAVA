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
		
		//1.��ȡע��
		Annotation[] annos = clazz.getAnnotations();
		for(Annotation anno:annos){
			System.out.println("ע�⣺"+anno);
		}
		
		//2.��ȡ���ڵİ�
		Package pack = clazz.getPackage();
		System.out.println("���ڰ���"+pack);
		
		//3.��ȡʵ�ֵ���
		Class[] interfaces = clazz.getInterfaces();
		for(Class inter:interfaces){
			System.out.println("ʵ�ֵ��ࣺ"+inter);
		}
		//4.��ȡ����
		Class superClass = clazz.getSuperclass();
		System.out.println("���ࣺ"+superClass);
		
		//5.��ȡ�����͵ĸ���
		Type type = clazz.getGenericSuperclass();
		System.out.println("�����͸��ࣺ"+type);
		//6.��ȡ����ķ���		
		Type superGener = clazz.getGenericSuperclass();
		
		ParameterizedType param = (ParameterizedType)superGener;
		Type[] ars = param.getActualTypeArguments();
		
		System.out.println("���෺�ͣ�"+((Class)ars[0]).getName());
		
		
		
		
	}
}
