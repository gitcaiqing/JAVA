package cq._09_Collections.Conllection.Set;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * Set:�洢��Ԫ��������ģ������ظ��ģ�
 *  1.�����ԣ������ԣ�= ����ԡ������������ԣ�ָ����Ԫ���ڵײ�洢��λ��������ġ�
 *	2.�����ظ��ԣ�����Set����ӽ���ͬ��Ԫ�ص�ʱ�򣬺�������������ӽ�ȥ��
 *
 *
 *
 *
 *
 */ 
public class TestTreeSet {
	
	@Test
	public void testTreeSet(){
		Set<String> set = new TreeSet<String>();
		set.add("s1");
		set.add("s2");
		set.add("s1");
		System.out.println("set:"+set);
	}
	
	/**
	 * ��Ӷ���
	 */
	@Test
	public void testSetAddObject(){
		//Set<Person> p_set = new TreeSet<Person>();
		//p_set.add(new Person("p1", 18));
		//p_set.add(new Person("p2", 19));
		//p_set.add(new Person("p3", 20));
		//System.out.println("p_set:"+p_set);
	}
	
}
