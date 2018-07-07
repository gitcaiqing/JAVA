package cq._09_Collections.Map.HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/*
 * Collection�ӿ�
 * 
 * Map�ӿ�
 * 		|-----HashMap:Map����Ҫʵ����
 * 		|-----LinkedHashMap:ʹ������ά����ӽ�Map�е�˳��
 * 							�ʱ���Mapʱ���ǰ���ӵ�˳������ġ�
 * 		|-----TreeMap:������ӽ�Map�е�Ԫ�ص�key��ָ�����Խ�������
				              Ҫ��key������ͬһ����Ķ���
 * 				             ���key����Ȼ����   vs ��������
 * 		|-----Hashtable:���ϵ�ʵ���࣬�̰߳�ȫ��������ʹ�á�
 * 	    |-----Properties:���������������ļ�������ֵ��ΪString���͵�
 */
public class TestHashMap {
	
	/**
	 * HashMap�� 
	 * 1.key����Set����ŵģ������ظ���
	 * 2.value����Collection����ŵģ����ظ�
	 */
	
	@Test
	public void testHashMap(){
		Map<Object, Object> hashMap = new HashMap<Object, Object>();
		hashMap.put("hm01", 1);
		hashMap.put("hm02", 2);
		hashMap.put("hm02", 3);
		System.out.println("hashMap:"+hashMap);
		
		hashMap.put(new Person("p01", 19), 4);
		System.out.println("hashMap:"+hashMap);
		
		hashMap.remove("hm02");
		System.out.println("hashMap:"+hashMap);
		
		System.out.println(hashMap.entrySet());
		for(Entry<Object, Object> entryset:hashMap.entrySet()) {
			System.out.println(entryset.getKey()+"---->"+entryset.getValue());
		}
		
		for(Map.Entry<Object,Object> entryset:hashMap.entrySet()) {
			System.out.println(entryset.getKey()+"---->"+entryset.getValue());
		}
		
		//����
		
		//����key
		Set keyset = hashMap.keySet();
		for(Object key:keyset){
			System.out.println("key�� "+key+"--->value�� "+hashMap.get(key));
			
		}
		//����value
		Collection values = hashMap.values();
		for(Object value : values){
			System.out.println("value:"+value);
		}
		
		//����keyset�������������
		Iterator it = keyset.iterator();
		while(it.hasNext()){
			//��ȡ��
			Object key = it.next();
			//���ݼ� ��ȡֵ
			Object value = hashMap.get(key);
			System.out.println("key�� "+key+"--->value�� "+value);
		}
		
		ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();
		
		
	}
}






class Person{
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}