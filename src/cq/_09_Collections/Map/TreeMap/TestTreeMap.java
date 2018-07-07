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
		
		//����
		//����1 ��ȡkey��Iterator
		Iterator<Integer> it = treeMap.keySet().iterator();
		while(it.hasNext()){
			System.out.println("value:"+treeMap.get(it.next()));
		}
		
		//����2
		
		//��Map������

		//values():�����ǻ�ȡ�����е����е�ֵ----û�м���û�ж�Ӧ��ϵ��
		
		//KeySet():
		//��Map�����еļ����뵽set�����С���Ϊset�߱���������
		//���п��Ե�����ʽȡ�����еļ����ٸ���get��������ȡÿһ������Ӧ��ֵ�� 
		//keySet():������ֻ��ͨ��get()ȡkey 

		//entrySet()��
		//Set<Map.Entry<K,V>> entrySet() 
		//���ش�ӳ���а�����ӳ���ϵ�� Set ��ͼ�� Map.Entry��ʾӳ���ϵ��
		//entrySet()�����������e.getKey()��e.getValue()ȡkey��value��
		//���ص���Entry�ӿ� ��
		Iterator<Entry<Integer, String>> it2 = treeMap.entrySet().iterator();
		
		while(it2.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)it2.next();
			
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key:"+key+"--->value:"+value);
		}
	}
}
