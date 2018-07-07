package cq._09_Collections.Conllection.Set;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/**
 * LinkedHashSet:ʹ������ά����һ����ӽ������е�˳�򡣵��µ����Ǳ���LinkedHashSet����
 * Ԫ��ʱ���ǰ�����ӽ�ȥ��˳������ģ�
 * 
 * LinkedHashSet���������Ե��� HashSet�����ڵ������� Set ���ȫ��Ԫ��ʱ�кܺõ����ܡ�
 */
public class TestLinkedHashSet {
	@Test
	public void testLinkedHashSet(){
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("l01");
		linkedHashSet.add("l02");
		linkedHashSet.add("l03");
		
		linkedHashSet.add("l02");
		linkedHashSet.add(new String("l02"));
		
		Iterator<String> it = linkedHashSet.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
			//l01 l02 l03
		}
	}
}
