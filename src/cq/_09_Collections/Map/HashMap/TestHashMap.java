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
 * Collection接口
 * 
 * Map接口
 * 		|-----HashMap:Map的主要实现类
 * 		|-----LinkedHashMap:使用链表维护添加进Map中的顺序。
 * 							故遍历Map时，是按添加的顺序遍历的。
 * 		|-----TreeMap:按照添加进Map中的元素的key的指定属性进行排序。
				              要求：key必须是同一个类的对象！
 * 				             针对key：自然排序   vs 定制排序
 * 		|-----Hashtable:古老的实现类，线程安全，不建议使用。
 * 	    |-----Properties:常用来处理属性文件。键和值都为String类型的
 */
public class TestHashMap {
	
	/**
	 * HashMap： 
	 * 1.key是用Set来存放的，不可重复。
	 * 2.value是用Collection来存放的，可重复
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
		
		//遍历
		
		//遍历key
		Set keyset = hashMap.keySet();
		for(Object key:keyset){
			System.out.println("key： "+key+"--->value： "+hashMap.get(key));
			
		}
		//遍历value
		Collection values = hashMap.values();
		for(Object value : values){
			System.out.println("value:"+value);
		}
		
		//有了keyset就有了其迭代器
		Iterator it = keyset.iterator();
		while(it.hasNext()){
			//获取键
			Object key = it.next();
			//根据键 获取值
			Object value = hashMap.get(key);
			System.out.println("key： "+key+"--->value： "+value);
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