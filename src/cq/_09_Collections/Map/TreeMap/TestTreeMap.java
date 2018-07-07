package cq._09_Collections.Map.TreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

public class TestTreeMap {
	@Test
	public void testTreeMap(){
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(1, "tm01");
		treeMap.put(2, "tm02");
		treeMap.put(3, "tm03");
		
		//遍历
		//方法1 获取key的Iterator
		Iterator<Integer> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			System.out.println("value:"+treeMap.get(it.next()));
		}
		
		//方法2
		
		//在Map集合中

		//values():方法是获取集合中的所有的值----没有键，没有对应关系，
		
		//KeySet():
		//将Map中所有的键存入到set集合中。因为set具备迭代器。
		//所有可以迭代方式取出所有的键，再根据get方法。获取每一个键对应的值。 
		//keySet():迭代后只能通过get()取key 

		//entrySet()：
		//Set<Map.Entry<K,V>> entrySet() 
		//返回此映射中包含的映射关系的 Set 视图。 Map.Entry表示映射关系。
		//entrySet()：迭代后可以e.getKey()，e.getValue()取key和value。
		//返回的是Entry接口 。
		Iterator<Entry<Integer, String>> it2 = treeMap.entrySet().iterator();
		
		while(it2.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)it2.next();
			
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:"+key+"--->value:"+value);
		}
	}
}
