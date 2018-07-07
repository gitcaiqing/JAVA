package cq._13_Reflection.Field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import cq._13_Reflection.TestReflection.Person;

public class TestField {
	/**
	 * ��ȡ����
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * 
	 */
	@Test
	public void testField() throws Exception{
		Class<Person> clazz = Person.class;
		
		//1.getFields()
		//��ȡ����ʱ�� ���丸���public����
		Field[] fields = clazz.getFields();
		for(int i=0; i<fields.length; i++){
			System.out.println("���༰�丸������ԣ�"+fields[i]);
		}
		System.out.println("-------------------------");
		
		//2.��ȡ���౾�������
		Field[] fieldSelf = clazz.getDeclaredFields();
		for(Field f:fieldSelf){
			System.out.println("��������ԣ�"+f);
			System.out.println("���Ե����֣�"+f.getName());
			//3��ȡÿ�����Ե�Ȩ�����η�
			int mod = f.getModifiers();
			String mdfStr = Modifier.toString(mod);
			System.out.println("Ȩ�����η���"+mdfStr);
			//4.��ȡ���Ե�����
			Class type = f.getType();
			System.out.println("���Ե����ͣ�"+type.getName());
			System.out.println("");
		}
		
		
		
		//5��ȡ������ض�����
		//getField(String fieldName):��ȡ����ʱ��������Ϊpublic��ָ��������ΪfieldName������
		Field age = clazz.getField("age");
		System.out.println("-------------------");
		System.out.println(age);
		
		//��������Ȩ�����η������ƣ�Ϊ�˱�֤���Ը����Ը�ֵ��
		//��Ҫ�ڲ���ǰʹ�ô����Կɱ�������
		age.setAccessible(true);
		
		//6����ʱ��ֵ
		Person p = clazz.newInstance();
		System.out.println("p:"+p);
		//
		
		age.set(p, 16);
		System.out.println("p2:"+p);
		System.out.println(age.get(p));
		
	}
	
}
