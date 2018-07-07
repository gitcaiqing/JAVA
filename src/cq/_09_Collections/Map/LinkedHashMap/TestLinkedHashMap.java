package cq._09_Collections.Map.LinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestLinkedHashMap {
	@Test
	public void testLinkedHashMap(){
		Map<Integer, String> linkHashMap = new LinkedHashMap<Integer, String>();
		linkHashMap.put(1, "lhm01");
		linkHashMap.put(2, "lhm02");
		linkHashMap.put(3, "lhm03");
		System.out.println(linkHashMap);
		Set<Integer> lhmkeySet = linkHashMap.keySet();
		for(Integer key:lhmkeySet){
			System.out.println("value:"+linkHashMap.get(key));
		}
		
		Iterator<Integer> it = lhmkeySet.iterator();
		while(it.hasNext()){
			System.out.println("key:"+it.next());
		}
		
	}
}
