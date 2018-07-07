package cq._13_Reflection.Constructor;

import java.lang.reflect.Constructor;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestConstructor {
	
	/**
	 * ͨ�������ȡ����ʱ��Ĺ�����
	 *Exception 
	 */
	@Test
	public void testConstructor() throws Exception{
		Class<Person> clazz = Person.class;
		//1.�����޲ι�����
		//������Ӧ������ʱ��Ķ���ʹ��newInstance()��
		//ʵ���Ͼ��ǵ���������ʱ��ĿղεĹ�������
		//Ҫ���ܹ������ɹ���
		//��Ҫ���Ӧ������ʱ��Ҫ�пղεĹ�������
		//�ڹ�������Ȩ�����η���Ȩ��Ҫ�㹻��
		Person p = clazz.newInstance();
		System.out.println(p);
		System.out.println("-----------------------");
		//2.���������˵Ĺ�����
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for(Constructor con:constructors){
			System.out.println(con);
		}
		
		System.out.println("-----------------------");
		
		//3.��ȡָ��������
		Constructor constructor = clazz.getDeclaredConstructor(String.class);
		System.out.println(constructor);
	}
	
	
	
}
